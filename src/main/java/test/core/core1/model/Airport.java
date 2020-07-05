/*
 * airport-service
 * api.description
 *
 * OpenAPI spec version: 1.0
 * Contact: api@demo.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package test.core.core1.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Airport
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2020-07-05T13:07:11.213Z")
public class Airport   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("cityId")
  private Long cityId = null;

  @JsonProperty("iataCode")
  private String iataCode = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("latitude")
  private Double latitude = null;

  @JsonProperty("longitude")
  private Double longitude = null;

  @JsonProperty("url")
  private String url = null;

  public Airport id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Airport cityId(Long cityId) {
    this.cityId = cityId;
    return this;
  }

  /**
   * Get cityId
   * @return cityId
   **/
  @JsonProperty("cityId")
  @ApiModelProperty(value = "")
  public Long getCityId() {
    return cityId;
  }

  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  public Airport iataCode(String iataCode) {
    this.iataCode = iataCode;
    return this;
  }

  /**
   * Get iataCode
   * @return iataCode
   **/
  @JsonProperty("iataCode")
  @ApiModelProperty(value = "")
  public String getIataCode() {
    return iataCode;
  }

  public void setIataCode(String iataCode) {
    this.iataCode = iataCode;
  }

  public Airport name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @JsonProperty("name")
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Airport status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @JsonProperty("status")
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Airport latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * @return latitude
   **/
  @JsonProperty("latitude")
  @ApiModelProperty(value = "")
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Airport longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * @return longitude
   **/
  @JsonProperty("longitude")
  @ApiModelProperty(value = "")
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Airport url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
   **/
  @JsonProperty("url")
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Airport airport = (Airport) o;
    return Objects.equals(this.id, airport.id) &&
        Objects.equals(this.cityId, airport.cityId) &&
        Objects.equals(this.iataCode, airport.iataCode) &&
        Objects.equals(this.name, airport.name) &&
        Objects.equals(this.status, airport.status) &&
        Objects.equals(this.latitude, airport.latitude) &&
        Objects.equals(this.longitude, airport.longitude) &&
        Objects.equals(this.url, airport.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cityId, iataCode, name, status, latitude, longitude, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Airport {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cityId: ").append(toIndentedString(cityId)).append("\n");
    sb.append("    iataCode: ").append(toIndentedString(iataCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

