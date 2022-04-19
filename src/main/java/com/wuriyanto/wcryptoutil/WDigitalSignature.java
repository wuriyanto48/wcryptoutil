package com.wuriyanto.wcryptoutil;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface WDigitalSignature {

    byte[] sign(PrivateKey privateKey, byte[] data) throws Exception;

    boolean verify(PublicKey publicKey, byte[] data, byte[] digitalSignature) throws Exception;
}
