package edu.unifacef.priceapi.domains;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

  private String productCode;
  private Double from;
  private Double to;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

}
