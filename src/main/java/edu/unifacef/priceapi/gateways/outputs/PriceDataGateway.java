package edu.unifacef.priceapi.gateways.outputs;

import edu.unifacef.priceapi.domains.Price;
import java.util.Optional;

public interface PriceDataGateway {

  Price save(Price price);

  Optional<Price> findByCode(String code);

}
