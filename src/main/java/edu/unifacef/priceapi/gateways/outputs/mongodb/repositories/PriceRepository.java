package edu.unifacef.priceapi.gateways.outputs.mongodb.repositories;

import edu.unifacef.priceapi.gateways.outputs.mongodb.documents.PriceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<PriceDocument, String> {
}
