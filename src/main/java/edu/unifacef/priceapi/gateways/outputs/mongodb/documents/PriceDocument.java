package edu.unifacef.priceapi.gateways.outputs.mongodb.documents;

import edu.unifacef.priceapi.domains.Price;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("prices")
public class PriceDocument {

  @Id
  private String id;
  private Double from;
  private Double to;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public PriceDocument(final Price price) {
    this.id = price.getProductCode();
    this.from = price.getFrom();
    this.to = price.getTo();
    this.createdDate = price.getCreatedDate();
    this.lastModifiedDate = price.getLastModifiedDate();
  }

  public Price toDomain() {
    return Price.builder()
        .productCode(this.id)
        .from(this.from)
        .to(this.to)
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}
