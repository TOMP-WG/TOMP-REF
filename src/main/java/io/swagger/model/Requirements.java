package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.model.KeyValue;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Requirements the users has ((dis)abilities, share [TRUE|FALSE], preferences [TBD]). See also &#x27;https://github.com/efel85/TOMP-API/blob/master/documents/Woordenboek%20Reizigerskenmerken%20CROW%20Eindversie%208%20mei%202019.pdf&#x27; [https://github.com/efel85/TOMP-API/issues/17 and https://github.com/efel85/TOMP-API/issues/27]
 */
@ApiModel(description = "Requirements the users has ((dis)abilities, share [TRUE|FALSE], preferences [TBD]). See also 'https://github.com/efel85/TOMP-API/blob/master/documents/Woordenboek%20Reizigerskenmerken%20CROW%20Eindversie%208%20mei%202019.pdf' [https://github.com/efel85/TOMP-API/issues/17 and https://github.com/efel85/TOMP-API/issues/27]")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-23T14:08:29.073Z[GMT]")
public class Requirements extends ArrayList<KeyValue>  {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Requirements {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
