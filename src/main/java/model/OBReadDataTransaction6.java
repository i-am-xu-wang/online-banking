package model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import model.OBTransaction6;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OBReadDataTransaction6
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-09T21:35:17.178398+02:00[Europe/Belgrade]")
public class OBReadDataTransaction6   {
  @JsonProperty("Transaction")
  @Valid
  private List<OBTransaction6> transaction = null;

  public OBReadDataTransaction6 transaction(List<OBTransaction6> transaction) {
    this.transaction = transaction;
    return this;
  }

  public OBReadDataTransaction6 addTransactionItem(OBTransaction6 transactionItem) {
    if (this.transaction == null) {
      this.transaction = new ArrayList<>();
    }
    this.transaction.add(transactionItem);
    return this;
  }

  /**
   * Get transaction
   * @return transaction
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<OBTransaction6> getTransaction() {
    return transaction;
  }

  public void setTransaction(List<OBTransaction6> transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadDataTransaction6 obReadDataTransaction6 = (OBReadDataTransaction6) o;
    return Objects.equals(this.transaction, obReadDataTransaction6.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadDataTransaction6 {\n");
    
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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

