/*
 * transfer-service
 * api.description
 *
 * OpenAPI spec version: 1.0
 * Contact: api@demo.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package test.composite.test.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Represents an transfer type of the system
 */
@ApiModel(description = "Represents an transfer type of the system")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-07-05T13:11:22.424Z")
public class TransferType   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("description")
  private String description = null;

  public TransferType id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the transfer type
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(required = true, value = "The ID of the transfer type")
  @NotNull
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TransferType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the transfer type
   * @return description
   **/
  @JsonProperty("description")
  @ApiModelProperty(required = true, value = "The description of the transfer type")
  @NotNull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferType transferType = (TransferType) o;
    return Objects.equals(this.id, transferType.id) &&
        Objects.equals(this.description, transferType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

