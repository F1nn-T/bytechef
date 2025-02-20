/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.11.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.user.web.rest;

import com.bytechef.platform.user.web.rest.model.AuthorityModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T09:54:20.204905+01:00[Europe/Zagreb]", comments = "Generator version: 7.11.0")
@Validated
@Tag(name = "authority", description = "The Platform User Authority Internal API")
public interface AuthorityApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /authorities : Get all authorities
     * Get all authorities.
     *
     * @return The list of authorities. (status code 200)
     */
    @Operation(
        operationId = "getAuthorities",
        summary = "Get all authorities",
        description = "Get all authorities.",
        tags = { "authority" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of authorities.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AuthorityModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/authorities",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<AuthorityModel>> getAuthorities(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"name\" : \"name\" }, { \"name\" : \"name\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
