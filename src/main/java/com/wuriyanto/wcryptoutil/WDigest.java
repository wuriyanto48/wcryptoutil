package com.wuriyanto.wcryptoutil;

import java.security.MessageDigest;

public final class WDigest {

    private WDigest() {

    }

    public static String sha1(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_1_DIGEST);
        messageDigest.update(data);
        return WKeyUtil.hexEncode(messageDigest.digest());
    }

    public static String sha256(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_256_DIGEST);
        messageDigest.update(data);
        return WKeyUtil.hexEncode(messageDigest.digest());
    }

    public static String sha384(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_384_DIGEST);
        messageDigest.update(data);
        return WKeyUtil.hexEncode(messageDigest.digest());
    }

    public static String sha512(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(WAlgorithm.SHA_512_DIGEST);
        messageDigest.update(data);
        return WKeyUtil.hexEncode(messageDigest.digest());
    }
}
