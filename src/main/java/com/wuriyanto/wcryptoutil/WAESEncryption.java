package com.wuriyanto.wcryptoutil;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public final class WAESEncryption implements WEncryption {

    private Key secretKey;
    private Cipher cipher;

    public WAESEncryption(Key secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.secretKey = secretKey;
        this.cipher = Cipher.getInstance(WAlgorithm.AES_GCM_NO_PADDING);
    }

    @Override
    public EncryptResult encrypt(byte[] plainData) throws Exception {
        byte[] iv = WKeyUtil.generateRandomIV();
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(WKeyUtil.GCM_TAG_LENGTH * 8, iv);

        this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, gcmParameterSpec);

        byte[] cipherText = this.cipher.doFinal(plainData);

        return new EncryptResult(cipherText, WKeyUtil.hexEncode(iv));

    }

    @Override
    public byte[] decrypt(byte[] cipherData, byte[] iv) throws Exception {
        iv = WKeyUtil.hexDecode(new String(iv));
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(WKeyUtil.GCM_TAG_LENGTH * 8, iv);

        this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey, gcmParameterSpec);

        byte[] plainData = this.cipher.doFinal(cipherData);
        return plainData;
    }
}
