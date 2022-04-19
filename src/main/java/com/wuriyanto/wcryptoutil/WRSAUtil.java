package com.wuriyanto.wcryptoutil;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public final class WRSAUtil {

    public static final Integer KEY_SIZE_1KB = 1 << 10; // 1024
    public static final Integer KEY_SIZE_2KB = 1 << 11; // 2048
    public static final Integer KEY_SIZE_4KB = 1 << 12; // 4096

    private int keySize;
    private KeyPair keyPair;

    public WRSAUtil(int keySize) {
        if (keySize != KEY_SIZE_1KB || keySize != KEY_SIZE_2KB)
            this.keySize = KEY_SIZE_2KB;
        else
            this.keySize = keySize;
    }

    public void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(WAlgorithm.RSA);
        keyPairGenerator.initialize(this.keySize);
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    // required private key with PKCS8 format
    // convert your RSA Private Key to PKCS8 format fist
    // $ openssl pkcs8 -topk8 -inform PEM -in private_key.pem -out private_key_pkcs8.pem -nocrypt
    public static PrivateKey loadPrivateKey(InputStream inputStream) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] keyBytes = buffer.toByteArray();

        byte[] decoded = Base64.getDecoder().decode(keyBytes);

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance(WAlgorithm.RSA);
        return kf.generatePrivate(spec);

    }

    public static PublicKey loadPublicKey(InputStream inputStream) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] keyBytes = buffer.toByteArray();

        byte[] decoded = Base64.getDecoder().decode(keyBytes);

        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance(WAlgorithm.RSA);
        return kf.generatePublic(spec);
    }

    public static String removePrivateKeyHeader(String base64Key) {
        base64Key = base64Key.replace("-----BEGIN PRIVATE KEY-----", "").replace("\n", "");
        base64Key = base64Key.replace("-----END PRIVATE KEY-----", "");
        return base64Key;
    }

    public static String removePublicKeyHeader(String base64Key) {
        base64Key = base64Key.replace("-----BEGIN PUBLIC KEY-----", "").replace("\n", "");
        base64Key = base64Key.replace("-----END PUBLIC KEY-----", "");
        return base64Key;
    }

    public PrivateKey getPrivateKey() throws Exception {
        if (this.keyPair == null)
            throw new Exception("key pair is null, call generateKeyPair first");
        return this.keyPair.getPrivate();
    }

    public PublicKey getPublicKey() throws Exception {
        if (this.keyPair == null)
            throw new Exception("key pair is null, call generateKeyPair first");
        return this.keyPair.getPublic();
    }

    public String getPrivateKeyBase64() throws Exception {
        if (this.keyPair == null)
            throw new Exception("key pair is null, call generateKeyPair first");
        return Base64.getEncoder().
                encodeToString(this.keyPair.getPrivate().getEncoded());
    }

    public String getPublicKeyBase64() throws Exception {
        if (this.keyPair == null)
            throw new Exception("key pair is null, call generateKeyPair first");
        return Base64.getEncoder().
                encodeToString(this.keyPair.getPublic().getEncoded());
    }

    public String getPrivateKeyFormat() throws Exception {
        if (this.keyPair == null)
            throw new Exception("key pair is null, call generateKeyPair first");
        return this.keyPair.getPrivate().getFormat();
    }

    public String getPublicKeyFormat() throws Exception {
        if (this.keyPair == null)
            throw new Exception("key pair is null, call generateKeyPair first");
        return this.keyPair.getPublic().getFormat();
    }
}
