package edu.unifacef.priceapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  PRICE_NOT_FOUND("price.not.found"),
  PRICE_ALREADY_EXISTS("price.already.exists"),
  PRICE_FROM_LESS_THAN_PRICE_TO("price.from.less.than.price.to");

  private String key;

}
