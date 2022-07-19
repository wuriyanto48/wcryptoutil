package com.wuriyanto.wcryptoutil;

public final class WAlgorithm {

    private WAlgorithm() {
    }

    // https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html

    public static final String AES = "AES";
    public static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";
    public static final String RSA = "RSA";
    public static final String RSA_OAEP_512 = "RSA/ECB/OAEPWithSHA-512AndMGF1Padding";

    public static final String ARCFOUR_KEY_GENERATOR = "ARCFOUR";
    public static final String BLOWFISH_KEY_GENERATOR = "Blowfish";
    public static final String DES_KEY_GENERATOR = "DES";
    public static final String DES_EDE_KEY_GENERATOR = "DESede";
    public static final String HMAC_MD5_KEY_GENERATOR = "HmacMD5";
    public static final String HMAC_SHA1_KEY_GENERATOR = "HmacSHA1";
    public static final String HMAC_SHA256_KEY_GENERATOR = "HmacSHA256";
    public static final String HMAC_SHA384_KEY_GENERATOR = "HmacSHA384";
    public static final String HMAC_SHA512_KEY_GENERATOR = "HmacSHA512";
    public static final String RC2_KEY_GENERATOR = "RC2";

    public static final String HMAC_MD5_MAC = "HmacMD5";
    public static final String HMAC_SHA1_MAC = "HmacSHA1";
    public static final String HMAC_SHA256_MAC = "HmacSHA256";
    public static final String HMAC_SHA384_MAC = "HmacSHA384";
    public static final String HMAC_SHA512_MAC = "HmacSHA512";

    public static final String MD5_DIGEST = "MD5";
    public static final String SHA_1_DIGEST = "SHA-1";
    public static final String SHA_256_DIGEST = "SHA-256";
    public static final String SHA_384_DIGEST = "SHA-384";
    public static final String SHA_512_DIGEST = "SHA-512";

    public static final String SHA_1_RSA_SIGN = "SHA1withRSA";
    public static final String SHA_256_RSA_SIGN = "SHA256withRSA";
    public static final String SHA_384_RSA_SIGN = "SHA384withRSA";
    public static final String SHA_512_RSA_SIGN = "SHA512withRSA";
}
