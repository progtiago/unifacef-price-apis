package edu.unifacef.priceapi.gateways.inputs.http;

import static edu.unifacef.priceapi.exceptions.MessageKey.PRICE_FROM_LESS_THAN_PRICE_TO;

import edu.unifacef.priceapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceValidator {

  private final MessageUtils messageUtils;

  public void validate(final PriceRequest priceRequest) {
    if(priceRequest.getFrom() <= priceRequest.getTo()) {
      throw new IllegalArgumentException(messageUtils.getMessage(PRICE_FROM_LESS_THAN_PRICE_TO));
    }
  }
}
