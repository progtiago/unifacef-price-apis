package edu.unifacef.priceapi.configurations.ff4j;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Features {

  SEND_TO_STORE(
      "send-to-store",
      "features",
      "Envia o preço cadastrado para a Store",
      true);

  private final String key;
  private final String groupName;
  private final String description;
  private final boolean defaultValue;

}
