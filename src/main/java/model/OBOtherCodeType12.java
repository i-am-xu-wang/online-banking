package model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Other calculation frequency which is not available in the standard code set.
 */
@ApiModel(description = "Other calculation frequency which is not available in the standard code set.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-09T21:35:17.178398+02:00[Europe/Belgrade]")
public class OBOtherCodeType12   {
  @JsonProperty("Code")
  private String code;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("Description")
  private String description;

  public OBOtherCodeType12 code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The four letter Mnemonic used within an XML file to identify a code
   * @return code
  */
  @ApiModelProperty(value = "The four letter Mnemonic used within an XML file to identify a code")

@Pattern(regexp="^\\\\w{0,4}$") 
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public OBOtherCodeType12 name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Long name associated with the code
   * @return name
  */
  @ApiModelProperty(required = true, value = "Long name associated with the code")
  @NotNull

@Size(min=1,max=70) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OBOtherCodeType12 description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description to describe the purpose of the code
   * @return description
  */
  @ApiModelProperty(required = true, value = "Description to describe the purpose of the code")
  @NotNull

@Size(min=1,max=350) 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBOtherCodeType12 obOtherCodeType12 = (OBOtherCodeType12) o;
    return Objects.equals(this.code, obOtherCodeType12.code) &&
        Objects.equals(this.name, obOtherCodeType12.name) &&
        Objects.equals(this.description, obOtherCodeType12.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBOtherCodeType12 {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

