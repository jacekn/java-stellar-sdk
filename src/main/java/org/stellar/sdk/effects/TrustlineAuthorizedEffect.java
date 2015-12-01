package org.stellar.sdk.effects;

import org.stellar.base.Keypair;

public class TrustlineAuthorizedEffect extends TrustlineAuthorization {
  TrustlineAuthorizedEffect(Keypair trustor, String assetType, String assetCode) {
    super(trustor, assetType, assetCode);
  }
}
