/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the ByteChef Enterprise license (the "Enterprise License");
 * you may not use this file except in compliance with the Enterprise License.
 */

package com.bytechef.ee.automation.configuration.facade;

import com.bytechef.atlas.configuration.domain.Workflow;
import com.bytechef.atlas.configuration.service.WorkflowService;
import com.bytechef.automation.configuration.domain.Project;
import com.bytechef.automation.configuration.domain.ProjectWorkflow;
import com.bytechef.automation.configuration.facade.ProjectFacade;
import com.bytechef.automation.configuration.service.ProjectService;
import com.bytechef.automation.configuration.service.ProjectWorkflowService;
import com.bytechef.ee.automation.configuration.domain.ProjectGitConfiguration;
import com.bytechef.ee.automation.configuration.service.ProjectGitConfigurationService;
import com.bytechef.ee.automation.configuration.service.ProjectGitService;
import com.bytechef.ee.platform.configuration.dto.GitConfigurationDTO;
import com.bytechef.ee.platform.configuration.facade.GitConfigurationFacade;
import com.bytechef.platform.annotation.ConditionalOnEEVersion;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version ee
 *
 * @author Ivica Cardic
 */
@Service
@Transactional
@ConditionalOnEEVersion
public class ProjectGitFacadeImpl implements ProjectGitFacade {

    private final GitConfigurationFacade gitConfigurationFacade;
    private final ProjectFacade projectFacade;
    private final ProjectGitConfigurationService projectGitConfigurationService;
    private final ProjectGitService projectGitService;
    private final ProjectService projectService;
    private final ProjectWorkflowService projectWorkflowService;
    private final WorkflowService workflowService;

    @SuppressFBWarnings("EI")
    public ProjectGitFacadeImpl(
        GitConfigurationFacade gitConfigurationFacade, ProjectFacade projectFacade,
        ProjectGitConfigurationService projectGitConfigurationService, ProjectGitService projectGitService,
        ProjectService projectService, ProjectWorkflowService projectWorkflowService, WorkflowService workflowService) {

        this.gitConfigurationFacade = gitConfigurationFacade;
        this.projectFacade = projectFacade;
        this.projectGitConfigurationService = projectGitConfigurationService;
        this.projectGitService = projectGitService;
        this.projectService = projectService;
        this.projectWorkflowService = projectWorkflowService;
        this.workflowService = workflowService;
    }

    @Override
    public void pullProjectFromGit(long projectId) {
        GitConfigurationDTO gitConfiguration = gitConfigurationFacade.getGitConfiguration();
        ProjectGitConfiguration projectGitConfiguration = projectGitConfigurationService.getProjectGitConfiguration(
            projectId);

        List<Workflow> workflows = projectGitService.getWorkflows(
            gitConfiguration.url(), projectGitConfiguration.getBranch(), gitConfiguration.username(),
            gitConfiguration.password());

        Project project = projectService.getProject(projectId);

        List<Workflow> oldWorkflows = projectWorkflowService
            .getProjectWorkflows(projectId, project.getLastVersion())
            .stream()
            .map(projectWorkflow -> workflowService.getWorkflow(projectWorkflow.getWorkflowId()))
            .toList();

        for (Workflow workflow : workflows) {
            Workflow oldWorkflow = oldWorkflows.stream()
                .filter(curWorkflow -> Objects.equals(curWorkflow.getLabel(), workflow.getLabel()))
                .findFirst()
                .orElse(null);

            if (oldWorkflow == null) {
                projectFacade.addWorkflow(projectId, workflow.getDefinition());
            } else {
                oldWorkflow.setDefinition(workflow.getDefinition());

                projectFacade.updateWorkflow(
                    Objects.requireNonNull(oldWorkflow.getId()), workflow.getDefinition(), oldWorkflow.getVersion());
            }
        }
    }

    @Override
    public void pushProjectToGit(long projectId, String commitMessage) {
        Project project = projectService.getProject(projectId);

        List<ProjectWorkflow> projectWorkflows = projectWorkflowService.getProjectWorkflows(
            projectId, project.getLastVersion());

        GitConfigurationDTO gitConfigurationDTO = gitConfigurationFacade.getGitConfiguration();
        ProjectGitConfiguration projectGitConfiguration = projectGitConfigurationService.getProjectGitConfiguration(
            projectId);

        projectGitService.commit(
            projectWorkflows.stream()
                .map(projectWorkflow -> workflowService.getWorkflow(projectWorkflow.getWorkflowId()))
                .toList(),
            commitMessage, gitConfigurationDTO.url(), projectGitConfiguration.getBranch(),
            gitConfigurationDTO.username(), gitConfigurationDTO.password());
    }
}
