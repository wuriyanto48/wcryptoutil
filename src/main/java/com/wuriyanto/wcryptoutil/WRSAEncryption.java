package com.wuriyanto.wcryptoutil;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;

public final class WRSAEncryption implements WEncryption {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    private Cipher cipher;

    public WRSAEncryption(PrivateKey privateKey, PublicKey publicKey) throws Exception {
        this.privateKey = privateKey;
        this.publicKey = publicKey;

        this.cipher = Cipher.getInstance(WAlgorithm.RSA_OAEP_512);
    }

    @Override
    public EncryptResult encrypt(byte[] plainData) throws Exception {
        this.cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = this.cipher.doFinal(plainData);
        return new EncryptResult(cipherText, null);
    }

    @Override
    public byte[] decrypt(byte[] cipherData, byte[] iv) throws Exception {
        this.cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] plainData = this.cipher.doFinal(cipherData);
        return plainData;
    }
}
