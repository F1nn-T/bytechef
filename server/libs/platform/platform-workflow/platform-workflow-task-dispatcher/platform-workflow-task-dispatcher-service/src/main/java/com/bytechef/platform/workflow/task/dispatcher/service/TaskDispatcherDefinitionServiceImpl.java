/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.platform.workflow.task.dispatcher.service;

import com.bytechef.commons.util.OptionalUtils;
import com.bytechef.definition.BaseOutputDefinition;
import com.bytechef.platform.domain.OutputResponse;
import com.bytechef.platform.util.SchemaUtils;
import com.bytechef.platform.util.WorkflowNodeDescriptionUtils;
import com.bytechef.platform.workflow.task.dispatcher.TaskDispatcherDefinitionRegistry;
import com.bytechef.platform.workflow.task.dispatcher.definition.OutputFunction;
import com.bytechef.platform.workflow.task.dispatcher.definition.PropertyFactory;
import com.bytechef.platform.workflow.task.dispatcher.domain.TaskDispatcherDefinition;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author Ivica Cardic
 */
@Service
public class TaskDispatcherDefinitionServiceImpl implements TaskDispatcherDefinitionService {

    private final TaskDispatcherDefinitionRegistry taskDispatcherDefinitionRegistry;

    @SuppressFBWarnings("EI2")
    public TaskDispatcherDefinitionServiceImpl(TaskDispatcherDefinitionRegistry taskDispatcherDefinitionRegistry) {
        this.taskDispatcherDefinitionRegistry = taskDispatcherDefinitionRegistry;
    }

    @Override
    public OutputResponse executeOutput(String name, int version, Map<String, ?> inputParameters) {
        com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDefinition taskDispatcherDefinition =
            taskDispatcherDefinitionRegistry.getTaskDispatcherDefinition(name, version);

        return taskDispatcherDefinition
            .getOutputDefinition()
            .flatMap(com.bytechef.platform.workflow.task.dispatcher.definition.OutputDefinition::getOutput)
            .map(f -> (OutputFunction) f)
            .map(outputFunction -> {
                try {
                    BaseOutputDefinition.OutputResponse outputDefinition = outputFunction.apply(inputParameters);

                    return SchemaUtils.toOutput(
                        outputDefinition, PropertyFactory.OUTPUT_FACTORY_FUNCTION, PropertyFactory.PROPERTY_FACTORY);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
            .orElse(null);
    }

    @Override
    public String executeWorkflowNodeDescription(String name, int version, Map<String, ?> inputParameters) {
        com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDefinition taskDispatcherDefinition =
            taskDispatcherDefinitionRegistry.getTaskDispatcherDefinition(name, version);

        return WorkflowNodeDescriptionUtils.renderTaskDispatcherProperties(
            inputParameters,
            OptionalUtils.orElse(taskDispatcherDefinition.getTitle(), taskDispatcherDefinition.getName()));
    }

    @Override
    public TaskDispatcherDefinition getTaskDispatcherDefinition(String name, int version) {
        return new TaskDispatcherDefinition(
            taskDispatcherDefinitionRegistry.getTaskDispatcherDefinition(name, version));
    }

    @Override
    public List<TaskDispatcherDefinition> getTaskDispatcherDefinitions() {
        return taskDispatcherDefinitionRegistry.getTaskDispatcherDefinitions()
            .stream()
            .map(TaskDispatcherDefinition::new)
            .toList();
    }

    @Override
    public List<TaskDispatcherDefinition> getTaskDispatcherDefinitionVersions(String name) {
        return taskDispatcherDefinitionRegistry.getTaskDispatcherDefinitions(name)
            .stream()
            .map(TaskDispatcherDefinition::new)
            .toList();
    }
}
