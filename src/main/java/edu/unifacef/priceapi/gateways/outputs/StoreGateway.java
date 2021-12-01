package edu.unifacef.priceapi.gateways.outputs;

import edu.unifacef.priceapi.domains.Price;

public interface StoreGateway {

  void send(Price price);

}
