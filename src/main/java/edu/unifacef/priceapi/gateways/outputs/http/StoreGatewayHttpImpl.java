package edu.unifacef.priceapi.gateways.outputs.http;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.gateways.outputs.StoreGateway;
import edu.unifacef.priceapi.gateways.outputs.http.resources.PriceResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreGatewayHttpImpl implements StoreGateway {

  private final StoreFeignIntegration storeFeignIntegration;

  @Override
  public void send(final Price price) {
    log.info("Sending price to Store. Product code: {}", price.getProductCode());
    PriceResource priceResource = new PriceResource(price);
    storeFeignIntegration.send(price.getProductCode(), priceResource);
  }
}
