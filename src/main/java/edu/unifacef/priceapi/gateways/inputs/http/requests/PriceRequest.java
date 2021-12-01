package edu.unifacef.priceapi.gateways.inputs.http.requests;

import edu.unifacef.priceapi.domains.Price;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PriceRequest implements Serializable {

  private static final long serialVersionUID = -5890495809969731782L;

  @ApiModelProperty(position = 0)
  @NotNull(message = "{required.field}")
  private Double from;

  @ApiModelProperty(position = 1)
  @NotNull(message = "{required.field}")
  private Double to;

  public Price toDomain(final String productCode) {
    return Price.builder()
        .productCode(productCode)
        .from(this.from)
        .to(this.to)
        .build();
  }
}
