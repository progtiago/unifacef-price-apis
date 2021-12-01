package edu.unifacef.priceapi.usecases;

import static edu.unifacef.priceapi.exceptions.MessageKey.PRICE_NOT_FOUND;

import edu.unifacef.priceapi.configurations.ff4j.Features;
import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.exceptions.NotFoundException;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.gateways.outputs.StoreGateway;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.FF4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdatePrice {

  private final PriceDataGateway priceDataGateway;
  private final StoreGateway storeGateway;
  private final MessageUtils messageUtils;
  private final FF4j ff4j;

  public Price execute(final Price price) {
    log.info("Update price. Product code: {}", price.getProductCode());
    Price oldPrice = priceDataGateway.findByCode(price.getProductCode()).orElseThrow(() ->
        new NotFoundException(messageUtils.getMessage(PRICE_NOT_FOUND, price.getProductCode())));
    price.setCreatedDate(oldPrice.getCreatedDate());

    Price saved = priceDataGateway.save(price);
    if(ff4j.check(Features.SEND_TO_STORE.getKey())) {
      storeGateway.send(saved);
    }
    return saved;
  }
}
