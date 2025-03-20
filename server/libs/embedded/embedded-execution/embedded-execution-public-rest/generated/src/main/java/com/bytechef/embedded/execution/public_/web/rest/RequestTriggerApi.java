/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.12.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.embedded.execution.public_.web.rest;

import com.bytechef.embedded.execution.public_.web.rest.model.EnvironmentModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-20T07:58:31.863654+01:00[Europe/Zagreb]", comments = "Generator version: 7.12.0")
@Validated
@Tag(name = "request-trigger", description = "The Embedded Request Trigger Public API")
public interface RequestTriggerApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workflows/{workflowReferenceCode} : Execute workflows
     * Execute workflows.
     *
     * @param workflowReferenceCode The workflow reference code. (required)
     * @param xEnvironment The environment. (optional)
     * @return The list of active integrations. (status code 200)
     */
    @Operation(
        operationId = "executeWorkflow",
        summary = "Execute workflows",
        description = "Execute workflows.",
        tags = { "request-trigger" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of active integrations.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/workflows/{workflowReferenceCode}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Object> executeWorkflow(
        @Parameter(name = "workflowReferenceCode", description = "The workflow reference code.", required = true, in = ParameterIn.PATH) @PathVariable("workflowReferenceCode") String workflowReferenceCode,
        @Parameter(name = "X-Environment", description = "The environment.", in = ParameterIn.HEADER) @RequestHeader(value = "X-Environment", required = false) EnvironmentModel xEnvironment
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
