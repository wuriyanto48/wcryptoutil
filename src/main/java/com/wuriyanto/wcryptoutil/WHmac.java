package com.wuriyanto.wcryptoutil;

import java.security.Key;
import javax.crypto.Mac;

public class WHmac {

    private WHmac() {

    }

    public static String md5(byte[] key, byte[]... data) throws Exception {
        Mac mac = init(key, WAlgorithm.HMAC_MD5_KEY_GENERATOR, WAlgorithm.HMAC_MD5_MAC);
        return doFinal(mac, data);
    }

    public static String sha1(byte[] key, byte[]... data) throws Exception {
        Mac mac = init(key, WAlgorithm.HMAC_SHA1_KEY_GENERATOR, WAlgorithm.HMAC_SHA1_MAC);
        return doFinal(mac, data);
    }

    public static String sha256(byte[] key, byte[]... data) throws Exception {
        Mac mac = init(key, WAlgorithm.HMAC_SHA256_KEY_GENERATOR, WAlgorithm.HMAC_SHA256_MAC);
        return doFinal(mac, data);
    }

    public static String sha384(byte[] key, byte[]... data) throws Exception {
        Mac mac = init(key, WAlgorithm.HMAC_SHA384_KEY_GENERATOR, WAlgorithm.HMAC_SHA384_MAC);
        return doFinal(mac, data);
    }

    public static String sha512(byte[] key, byte[]... data) throws Exception {
        Mac mac = init(key, WAlgorithm.HMAC_SHA512_KEY_GENERATOR, WAlgorithm.HMAC_SHA512_MAC);
        return doFinal(mac, data);
    }

    private static Mac init(byte[] key, String keyGeneratorAlg, String alg) throws Exception{
        Mac mac = Mac.getInstance(alg);
        Key secretKey = WKeyUtil.from(key, keyGeneratorAlg);
        mac.init(secretKey);
        return mac;
    }

    private static String doFinal(Mac mac, byte[]... datas) {
        for (byte[] data : datas) {
            mac.update(data);
        }
        return WKeyUtil.hexEncode(mac.doFinal());
    }
}
