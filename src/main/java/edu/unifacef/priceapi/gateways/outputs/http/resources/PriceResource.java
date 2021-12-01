package edu.unifacef.priceapi.gateways.outputs.http.resources;

import edu.unifacef.priceapi.domains.Price;
import java.io.Serializable;
import lombok.Data;

@Data
public class PriceResource implements Serializable {

  private static final long serialVersionUID = -4791720516100938297L;

  private Double from;
  private Double to;

  public PriceResource(final Price price) {
    this.from = price.getFrom();
    this.to = price.getTo();
  }
}
