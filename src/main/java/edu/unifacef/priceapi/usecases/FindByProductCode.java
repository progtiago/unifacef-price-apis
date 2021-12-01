package edu.unifacef.priceapi.usecases;

import static edu.unifacef.priceapi.exceptions.MessageKey.PRICE_NOT_FOUND;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.exceptions.NotFoundException;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByProductCode {

  private final PriceDataGateway priceDataGateway;
  private final MessageUtils messageUtils;

  public Price execute(final String productCode) {
    log.info("Find price. Product code: {}", productCode);
    return priceDataGateway.findByCode(productCode).orElseThrow(
        () -> new NotFoundException(messageUtils.getMessage(PRICE_NOT_FOUND, productCode)));
  }
}
