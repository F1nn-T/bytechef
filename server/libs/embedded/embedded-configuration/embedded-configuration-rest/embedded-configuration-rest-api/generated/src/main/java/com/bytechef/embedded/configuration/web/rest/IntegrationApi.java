/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.embedded.configuration.web.rest;

import com.bytechef.embedded.configuration.web.rest.model.IntegrationModel;
import com.bytechef.embedded.configuration.web.rest.model.IntegrationStatusModel;
import com.bytechef.embedded.configuration.web.rest.model.IntegrationVersionModel;
import com.bytechef.embedded.configuration.web.rest.model.PublishIntegrationRequestModel;
import com.bytechef.embedded.configuration.web.rest.model.WorkflowModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-10T06:16:00.287813+01:00[Europe/Zagreb]", comments = "Generator version: 7.10.0")
@Validated
@Tag(name = "integration", description = "The Embedded Integration Internal API")
public interface IntegrationApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /integrations : Create a new integration
     * Create a new integration.
     *
     * @param integrationModel  (required)
     * @return The integration id. (status code 200)
     */
    @Operation(
        operationId = "createIntegration",
        summary = "Create a new integration",
        description = "Create a new integration.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The integration id.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/integrations",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Long> createIntegration(
        @Parameter(name = "IntegrationModel", description = "", required = true) @Valid @RequestBody IntegrationModel integrationModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /integrations/{id}/workflows : Create new workflow and adds it to an existing integration
     * Create new workflow and adds it to an existing integration.
     *
     * @param id The id of an integration. (required)
     * @param workflowModel  (required)
     * @return The integration workflow id. (status code 200)
     */
    @Operation(
        operationId = "createIntegrationWorkflow",
        summary = "Create new workflow and adds it to an existing integration",
        description = "Create new workflow and adds it to an existing integration.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The integration workflow id.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/integrations/{id}/workflows",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Long> createIntegrationWorkflow(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "WorkflowModel", description = "", required = true) @Valid @RequestBody WorkflowModel workflowModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /integrations/{id} : Delete an integration
     * Delete an integration.
     *
     * @param id The id of an integration. (required)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "deleteIntegration",
        summary = "Delete an integration",
        description = "Delete an integration.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/integrations/{id}"
    )
    
    default ResponseEntity<Void> deleteIntegration(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /integrations/{id} : Get an integration by id
     * Get an integration by id.
     *
     * @param id The id of an integration. (required)
     * @return The integration object. (status code 200)
     */
    @Operation(
        operationId = "getIntegration",
        summary = "Get an integration by id",
        description = "Get an integration by id.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The integration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IntegrationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<IntegrationModel> getIntegration(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"integrationWorkflowIds\" : [ 5, 5 ], \"lastPublishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"icon\" : \"icon\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 } ], \"allowMultipleInstances\" : false, \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 0, \"category\" : { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, \"lastIntegrationVersion\" : 6, \"lastStatus\" : \"DRAFT\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /integrations/{id}/versions : Get a integration versions.
     * Get a integration versions.
     *
     * @param id The id of an integration. (required)
     * @return The list of integration version objects. (status code 200)
     */
    @Operation(
        operationId = "getIntegrationVersions",
        summary = "Get a integration versions.",
        description = "Get a integration versions.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of integration version objects.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = IntegrationVersionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations/{id}/versions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<IntegrationVersionModel>> getIntegrationVersions(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"description\" : \"description\", \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"version\" : 0, \"status\" : \"DRAFT\" }, { \"description\" : \"description\", \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"version\" : 0, \"status\" : \"DRAFT\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /integrations : Get integrations
     * Get integrations.
     *
     * @param categoryId The category id used for filtering integrations. (optional)
     * @param integrationInstanceConfigurations Use for filtering integrations for which integration instance configurations exist. (optional)
     * @param status Use for filtering integrations by status. (optional)
     * @param tagId The tag id of used for filtering integrations. (optional)
     * @param includeAllFields Use for including all fields or just basic ones. (optional, default to true)
     * @return The list of integrations. (status code 200)
     */
    @Operation(
        operationId = "getIntegrations",
        summary = "Get integrations",
        description = "Get integrations.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of integrations.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = IntegrationModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<IntegrationModel>> getIntegrations(
        @Parameter(name = "categoryId", description = "The category id used for filtering integrations.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "categoryId", required = false) Long categoryId,
        @Parameter(name = "integrationInstanceConfigurations", description = "Use for filtering integrations for which integration instance configurations exist.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "integrationInstanceConfigurations", required = false) Boolean integrationInstanceConfigurations,
        @Parameter(name = "status", description = "Use for filtering integrations by status.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "status", required = false) IntegrationStatusModel status,
        @Parameter(name = "tagId", description = "The tag id of used for filtering integrations.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tagId", required = false) Long tagId,
        @Parameter(name = "includeAllFields", description = "Use for including all fields or just basic ones.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "includeAllFields", required = false, defaultValue = "true") Boolean includeAllFields
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"integrationWorkflowIds\" : [ 5, 5 ], \"lastPublishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"icon\" : \"icon\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 } ], \"allowMultipleInstances\" : false, \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 0, \"category\" : { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, \"lastIntegrationVersion\" : 6, \"lastStatus\" : \"DRAFT\" }, { \"integrationWorkflowIds\" : [ 5, 5 ], \"lastPublishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"icon\" : \"icon\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 } ], \"allowMultipleInstances\" : false, \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 0, \"category\" : { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, \"lastIntegrationVersion\" : 6, \"lastStatus\" : \"DRAFT\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /integrations/{id}/publish : Publishes existing integration.
     * Publishes existing integration.
     *
     * @param id The id of a integration. (required)
     * @param publishIntegrationRequestModel  (optional)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "publishIntegration",
        summary = "Publishes existing integration.",
        description = "Publishes existing integration.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/integrations/{id}/publish",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> publishIntegration(
        @Parameter(name = "id", description = "The id of a integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "PublishIntegrationRequestModel", description = "") @Valid @RequestBody(required = false) PublishIntegrationRequestModel publishIntegrationRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /integrations/{id} : Update an existing integration
     * Update an existing integration.
     *
     * @param id The id of an integration. (required)
     * @param integrationModel  (required)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "updateIntegration",
        summary = "Update an existing integration",
        description = "Update an existing integration.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/integrations/{id}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> updateIntegration(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "IntegrationModel", description = "", required = true) @Valid @RequestBody IntegrationModel integrationModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
