package com.wuriyanto.wcryptoutil;

import java.security.MessageDigest;

public final class WDigest {

    private WDigest() {

    }

    public static String md5(byte[]... data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.MD5_DIGEST);
        return digest(messageDigest, data);
    }

    public static String sha1(byte[]... data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_1_DIGEST);
        return digest(messageDigest, data);
    }

    public static String sha256(byte[]... data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_256_DIGEST);
        return digest(messageDigest, data);
    }

    public static String sha384(byte[]... data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_384_DIGEST);
        return digest(messageDigest, data);
    }

    public static String sha512(byte[]... data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_512_DIGEST);
        return digest(messageDigest, data);
    }

    private static String digest(MessageDigest messageDigest, byte[]... datas) {
        for (byte[] data : datas) {
            messageDigest.update(data);
        }
        
        return WKeyUtil.hexEncode(messageDigest.digest());
    }
}
