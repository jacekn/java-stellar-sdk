package org.stellar.sdk.effects;

public class SignerRemovedEffect extends SignerEffect {
  SignerRemovedEffect(Integer weight, String publicKey) {
    super(weight, publicKey);
  }
}
