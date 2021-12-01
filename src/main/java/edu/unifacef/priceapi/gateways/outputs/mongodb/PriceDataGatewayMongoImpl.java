package edu.unifacef.priceapi.gateways.outputs.mongodb;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.gateways.outputs.mongodb.documents.PriceDocument;
import edu.unifacef.priceapi.gateways.outputs.mongodb.repositories.PriceRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceDataGatewayMongoImpl implements PriceDataGateway {

  private final PriceRepository priceRepository;

  @Override
  public Price save(final Price price) {
    if(Objects.isNull(price.getCreatedDate())) {
      price.setCreatedDate(LocalDateTime.now());
    }
    return priceRepository.save(new PriceDocument(price)).toDomain();
  }

  @Override
  public Optional<Price> findByCode(final String code) {
    return priceRepository.findById(code).map(PriceDocument::toDomain);
  }

}
