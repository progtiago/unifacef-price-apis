package edu.unifacef.priceapi.gateways.inputs.http;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.priceapi.gateways.inputs.http.responses.PriceResponse;
import edu.unifacef.priceapi.usecases.CreatePrice;
import edu.unifacef.priceapi.usecases.FindByProductCode;
import edu.unifacef.priceapi.usecases.UpdatePrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products/{productCode}/prices")
public class PriceController {

  private final CreatePrice createPrice;
  private final UpdatePrice updatePrice;
  private final FindByProductCode findByProductCode;
  private final PriceValidator priceValidator;

  @PostMapping
  public PriceResponse create(@PathVariable final String productCode,
                              @RequestBody @Validated final PriceRequest request) {
    priceValidator.validate(request);
    Price price = createPrice.execute(request.toDomain(productCode));
    return new PriceResponse(price);
  }

  @PutMapping
  public PriceResponse update(@PathVariable final String productCode,
                              @RequestBody @Validated final PriceRequest request) {
    priceValidator.validate(request);
    Price price = updatePrice.execute(request.toDomain(productCode));
    return new PriceResponse(price);
  }

  @GetMapping
  public PriceResponse find(@PathVariable final String productCode) {
    Price price = findByProductCode.execute(productCode);
    return new PriceResponse(price);
  }
}
