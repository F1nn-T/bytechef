package com.bytechef.hermes.component.web.rest.model;

import java.net.URI;
import java.util.Objects;
import com.bytechef.hermes.component.web.rest.model.DisplayOptionModel;
import com.bytechef.hermes.component.web.rest.model.EditorTypeModel;
import com.bytechef.hermes.component.web.rest.model.PropertyTypeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * StringPropertyModel
 */

@JsonTypeName("StringProperty")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-27T16:22:37.776273+02:00[Europe/Zagreb]")
public class StringPropertyModel implements ComponentActionInputsInnerModel, ConnectionDefinitionPropertiesInnerModel {

  @JsonProperty("editorType")
  private EditorTypeModel editorType;

  @JsonProperty("description")
  private String description;

  @JsonProperty("displayOption")
  private DisplayOptionModel displayOption;

  @JsonProperty("label")
  private String label;

  @JsonProperty("name")
  private String name;

  @JsonProperty("placeholder")
  private String placeholder;

  @JsonProperty("type")
  private PropertyTypeModel type;

  public StringPropertyModel editorType(EditorTypeModel editorType) {
    this.editorType = editorType;
    return this;
  }

  /**
   * Get editorType
   * @return editorType
  */
  @Valid 
  @Schema(name = "editorType", required = false)
  public EditorTypeModel getEditorType() {
    return editorType;
  }

  public void setEditorType(EditorTypeModel editorType) {
    this.editorType = editorType;
  }

  public StringPropertyModel description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public StringPropertyModel displayOption(DisplayOptionModel displayOption) {
    this.displayOption = displayOption;
    return this;
  }

  /**
   * Get displayOption
   * @return displayOption
  */
  @Valid 
  @Schema(name = "displayOption", required = false)
  public DisplayOptionModel getDisplayOption() {
    return displayOption;
  }

  public void setDisplayOption(DisplayOptionModel displayOption) {
    this.displayOption = displayOption;
  }

  public StringPropertyModel label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  */
  
  @Schema(name = "label", required = false)
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public StringPropertyModel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StringPropertyModel placeholder(String placeholder) {
    this.placeholder = placeholder;
    return this;
  }

  /**
   * Get placeholder
   * @return placeholder
  */
  
  @Schema(name = "placeholder", required = false)
  public String getPlaceholder() {
    return placeholder;
  }

  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  public StringPropertyModel type(PropertyTypeModel type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Valid 
  @Schema(name = "type", required = false)
  public PropertyTypeModel getType() {
    return type;
  }

  public void setType(PropertyTypeModel type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringPropertyModel stringProperty = (StringPropertyModel) o;
    return Objects.equals(this.editorType, stringProperty.editorType) &&
        Objects.equals(this.description, stringProperty.description) &&
        Objects.equals(this.displayOption, stringProperty.displayOption) &&
        Objects.equals(this.label, stringProperty.label) &&
        Objects.equals(this.name, stringProperty.name) &&
        Objects.equals(this.placeholder, stringProperty.placeholder) &&
        Objects.equals(this.type, stringProperty.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(editorType, description, displayOption, label, name, placeholder, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StringPropertyModel {\n");
    sb.append("    editorType: ").append(toIndentedString(editorType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayOption: ").append(toIndentedString(displayOption)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    placeholder: ").append(toIndentedString(placeholder)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

