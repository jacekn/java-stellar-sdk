// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union HashIDPreimage switch (EnvelopeType type)
//  {
//  case ENVELOPE_TYPE_OP_ID:
//      struct
//      {
//          AccountID sourceAccount;
//          SequenceNumber seqNum;
//          uint32 opNum;
//      } operationID;
//  case ENVELOPE_TYPE_POOL_REVOKE_OP_ID:
//      struct
//      {
//          AccountID sourceAccount;
//          SequenceNumber seqNum;
//          uint32 opNum;
//          PoolID liquidityPoolID;
//          Asset asset;
//      } revokeID;
//  };

//  ===========================================================================
public class HashIDPreimage implements XdrElement {
  public HashIDPreimage () {}
  EnvelopeType type;
  public EnvelopeType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(EnvelopeType value) {
    this.type = value;
  }
  private HashIDPreimageOperationID operationID;
  public HashIDPreimageOperationID getOperationID() {
    return this.operationID;
  }
  public void setOperationID(HashIDPreimageOperationID value) {
    this.operationID = value;
  }
  private HashIDPreimageRevokeID revokeID;
  public HashIDPreimageRevokeID getRevokeID() {
    return this.revokeID;
  }
  public void setRevokeID(HashIDPreimageRevokeID value) {
    this.revokeID = value;
  }

  public static final class Builder {
    private EnvelopeType discriminant;
    private HashIDPreimageOperationID operationID;
    private HashIDPreimageRevokeID revokeID;

    public Builder discriminant(EnvelopeType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder operationID(HashIDPreimageOperationID operationID) {
      this.operationID = operationID;
      return this;
    }

    public Builder revokeID(HashIDPreimageRevokeID revokeID) {
      this.revokeID = revokeID;
      return this;
    }

    public HashIDPreimage build() {
      HashIDPreimage val = new HashIDPreimage();
      val.setDiscriminant(discriminant);
      val.setOperationID(operationID);
      val.setRevokeID(revokeID);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, HashIDPreimage encodedHashIDPreimage) throws IOException {
  //Xdrgen::AST::Identifier
  //EnvelopeType
  stream.writeInt(encodedHashIDPreimage.getDiscriminant().getValue());
  switch (encodedHashIDPreimage.getDiscriminant()) {
  case ENVELOPE_TYPE_OP_ID:
  HashIDPreimageOperationID.encode(stream, encodedHashIDPreimage.operationID);
  break;
  case ENVELOPE_TYPE_POOL_REVOKE_OP_ID:
  HashIDPreimageRevokeID.encode(stream, encodedHashIDPreimage.revokeID);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static HashIDPreimage decode(XdrDataInputStream stream) throws IOException {
  HashIDPreimage decodedHashIDPreimage = new HashIDPreimage();
  EnvelopeType discriminant = EnvelopeType.decode(stream);
  decodedHashIDPreimage.setDiscriminant(discriminant);
  switch (decodedHashIDPreimage.getDiscriminant()) {
  case ENVELOPE_TYPE_OP_ID:
  decodedHashIDPreimage.operationID = HashIDPreimageOperationID.decode(stream);
  break;
  case ENVELOPE_TYPE_POOL_REVOKE_OP_ID:
  decodedHashIDPreimage.revokeID = HashIDPreimageRevokeID.decode(stream);
  break;
  }
    return decodedHashIDPreimage;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.operationID, this.revokeID, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof HashIDPreimage)) {
      return false;
    }

    HashIDPreimage other = (HashIDPreimage) object;
    return Objects.equal(this.operationID, other.operationID) && Objects.equal(this.revokeID, other.revokeID) && Objects.equal(this.type, other.type);
  }

  public static class HashIDPreimageOperationID {
    public HashIDPreimageOperationID () {}
    private AccountID sourceAccount;
    public AccountID getSourceAccount() {
      return this.sourceAccount;
    }
    public void setSourceAccount(AccountID value) {
      this.sourceAccount = value;
    }
    private SequenceNumber seqNum;
    public SequenceNumber getSeqNum() {
      return this.seqNum;
    }
    public void setSeqNum(SequenceNumber value) {
      this.seqNum = value;
    }
    private Uint32 opNum;
    public Uint32 getOpNum() {
      return this.opNum;
    }
    public void setOpNum(Uint32 value) {
      this.opNum = value;
    }
    public static void encode(XdrDataOutputStream stream, HashIDPreimageOperationID encodedHashIDPreimageOperationID) throws IOException{
      AccountID.encode(stream, encodedHashIDPreimageOperationID.sourceAccount);
      SequenceNumber.encode(stream, encodedHashIDPreimageOperationID.seqNum);
      Uint32.encode(stream, encodedHashIDPreimageOperationID.opNum);
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static HashIDPreimageOperationID decode(XdrDataInputStream stream) throws IOException {
      HashIDPreimageOperationID decodedHashIDPreimageOperationID = new HashIDPreimageOperationID();
      decodedHashIDPreimageOperationID.sourceAccount = AccountID.decode(stream);
      decodedHashIDPreimageOperationID.seqNum = SequenceNumber.decode(stream);
      decodedHashIDPreimageOperationID.opNum = Uint32.decode(stream);
      return decodedHashIDPreimageOperationID;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.sourceAccount, this.seqNum, this.opNum);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof HashIDPreimageOperationID)) {
        return false;
      }

      HashIDPreimageOperationID other = (HashIDPreimageOperationID) object;
      return Objects.equal(this.sourceAccount, other.sourceAccount) && Objects.equal(this.seqNum, other.seqNum) && Objects.equal(this.opNum, other.opNum);
    }

    public static final class Builder {
      private AccountID sourceAccount;
      private SequenceNumber seqNum;
      private Uint32 opNum;

      public Builder sourceAccount(AccountID sourceAccount) {
        this.sourceAccount = sourceAccount;
        return this;
      }

      public Builder seqNum(SequenceNumber seqNum) {
        this.seqNum = seqNum;
        return this;
      }

      public Builder opNum(Uint32 opNum) {
        this.opNum = opNum;
        return this;
      }

      public HashIDPreimageOperationID build() {
        HashIDPreimageOperationID val = new HashIDPreimageOperationID();
        val.setSourceAccount(sourceAccount);
        val.setSeqNum(seqNum);
        val.setOpNum(opNum);
        return val;
      }
    }

  }
  public static class HashIDPreimageRevokeID {
    public HashIDPreimageRevokeID () {}
    private AccountID sourceAccount;
    public AccountID getSourceAccount() {
      return this.sourceAccount;
    }
    public void setSourceAccount(AccountID value) {
      this.sourceAccount = value;
    }
    private SequenceNumber seqNum;
    public SequenceNumber getSeqNum() {
      return this.seqNum;
    }
    public void setSeqNum(SequenceNumber value) {
      this.seqNum = value;
    }
    private Uint32 opNum;
    public Uint32 getOpNum() {
      return this.opNum;
    }
    public void setOpNum(Uint32 value) {
      this.opNum = value;
    }
    private PoolID liquidityPoolID;
    public PoolID getLiquidityPoolID() {
      return this.liquidityPoolID;
    }
    public void setLiquidityPoolID(PoolID value) {
      this.liquidityPoolID = value;
    }
    private Asset asset;
    public Asset getAsset() {
      return this.asset;
    }
    public void setAsset(Asset value) {
      this.asset = value;
    }
    public static void encode(XdrDataOutputStream stream, HashIDPreimageRevokeID encodedHashIDPreimageRevokeID) throws IOException{
      AccountID.encode(stream, encodedHashIDPreimageRevokeID.sourceAccount);
      SequenceNumber.encode(stream, encodedHashIDPreimageRevokeID.seqNum);
      Uint32.encode(stream, encodedHashIDPreimageRevokeID.opNum);
      PoolID.encode(stream, encodedHashIDPreimageRevokeID.liquidityPoolID);
      Asset.encode(stream, encodedHashIDPreimageRevokeID.asset);
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static HashIDPreimageRevokeID decode(XdrDataInputStream stream) throws IOException {
      HashIDPreimageRevokeID decodedHashIDPreimageRevokeID = new HashIDPreimageRevokeID();
      decodedHashIDPreimageRevokeID.sourceAccount = AccountID.decode(stream);
      decodedHashIDPreimageRevokeID.seqNum = SequenceNumber.decode(stream);
      decodedHashIDPreimageRevokeID.opNum = Uint32.decode(stream);
      decodedHashIDPreimageRevokeID.liquidityPoolID = PoolID.decode(stream);
      decodedHashIDPreimageRevokeID.asset = Asset.decode(stream);
      return decodedHashIDPreimageRevokeID;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.sourceAccount, this.seqNum, this.opNum, this.liquidityPoolID, this.asset);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof HashIDPreimageRevokeID)) {
        return false;
      }

      HashIDPreimageRevokeID other = (HashIDPreimageRevokeID) object;
      return Objects.equal(this.sourceAccount, other.sourceAccount) && Objects.equal(this.seqNum, other.seqNum) && Objects.equal(this.opNum, other.opNum) && Objects.equal(this.liquidityPoolID, other.liquidityPoolID) && Objects.equal(this.asset, other.asset);
    }

    public static final class Builder {
      private AccountID sourceAccount;
      private SequenceNumber seqNum;
      private Uint32 opNum;
      private PoolID liquidityPoolID;
      private Asset asset;

      public Builder sourceAccount(AccountID sourceAccount) {
        this.sourceAccount = sourceAccount;
        return this;
      }

      public Builder seqNum(SequenceNumber seqNum) {
        this.seqNum = seqNum;
        return this;
      }

      public Builder opNum(Uint32 opNum) {
        this.opNum = opNum;
        return this;
      }

      public Builder liquidityPoolID(PoolID liquidityPoolID) {
        this.liquidityPoolID = liquidityPoolID;
        return this;
      }

      public Builder asset(Asset asset) {
        this.asset = asset;
        return this;
      }

      public HashIDPreimageRevokeID build() {
        HashIDPreimageRevokeID val = new HashIDPreimageRevokeID();
        val.setSourceAccount(sourceAccount);
        val.setSeqNum(seqNum);
        val.setOpNum(opNum);
        val.setLiquidityPoolID(liquidityPoolID);
        val.setAsset(asset);
        return val;
      }
    }

  }
}
