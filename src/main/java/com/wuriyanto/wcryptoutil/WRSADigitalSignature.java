package com.wuriyanto.wcryptoutil;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public final class WRSADigitalSignature implements WDigitalSignature {

    private Signature signature;

    public WRSADigitalSignature() throws Exception {
        signature = Signature.getInstance(WAlgorithm.SHA_512_RSA_SIGN);
    }

    @Override
    public byte[] sign(PrivateKey privateKey, byte[] data) throws Exception {
        SecureRandom secureRandom = new SecureRandom();

        signature.initSign(privateKey, secureRandom);
        signature.update(data);
        return signature.sign();
    }

    @Override
    public boolean verify(PublicKey publicKey, byte[] data, byte[] digitalSignature) throws Exception {
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(digitalSignature);
    }
}
