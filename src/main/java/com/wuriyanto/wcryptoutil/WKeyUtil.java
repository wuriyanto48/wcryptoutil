package com.wuriyanto.wcryptoutil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class WKeyUtil {

    public static final Integer SYMMETRIC_KEY_SIZE = 256;
    public static final Integer KEY_SIZE = 32;
    public static final Integer IV_SIZE = 12;
    public static final Integer GCM_TAG_LENGTH = 16;

    private WKeyUtil() {

    }

    public static Key generateRandomSymmetricKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(WAlgorithm.AES);
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(SYMMETRIC_KEY_SIZE, secureRandom);
        return keyGenerator.generateKey();
    }

    public static Key from(String key) throws Exception {
        return from(key.getBytes());
    }

    public static Key from(byte[] key) throws Exception {
        if (key.length < KEY_SIZE)
            throw new Exception("key cannot less than " + KEY_SIZE);
        SecretKeySpec secretKeySpec = from(key, WAlgorithm.AES);
        return secretKeySpec;
    }

    public static SecretKeySpec from(byte[] key, String alg) throws Exception {
        if (key.length < KEY_SIZE)
            throw new Exception("key cannot less than " + KEY_SIZE);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, alg);
        return secretKeySpec;
    }

    public static byte[] generateRandomIV() {
        byte[] IV = new byte[IV_SIZE];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);
        return IV;
    }

    public static String hexEncode(byte[] bytes) {
        return new String(Hex.encodeHex(bytes));
    }

    public static byte[] hexDecode(String hexString) throws DecoderException {
        return Hex.decodeHex(hexString);
    }
}
