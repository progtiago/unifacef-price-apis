package edu.unifacef.priceapi.gateways.inputs.http.responses;

import edu.unifacef.priceapi.domains.Price;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PriceResponse implements Serializable {

  private static final long serialVersionUID = 1161637631508029027L;

  @ApiModelProperty(position = 0)
  private String productCode;

  @ApiModelProperty(position = 1)
  private Double from;

  @ApiModelProperty(position = 2)
  private Double to;

  @ApiModelProperty(position = 3)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 4)
  private LocalDateTime lastModifiedDate;

  public PriceResponse(final Price price) {
    this.productCode = price.getProductCode();
    this.from = price.getFrom();
    this.to = price.getTo();
    this.createdDate = price.getCreatedDate();
    this.lastModifiedDate = price.getLastModifiedDate();
  }

}
