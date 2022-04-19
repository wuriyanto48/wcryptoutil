package com.wuriyanto.wcryptoutil;

public interface WEncryption {

    EncryptResult encrypt(byte[] plainData) throws Exception;

    byte[] decrypt(byte[] cipherData, byte[] iv) throws Exception;
}
