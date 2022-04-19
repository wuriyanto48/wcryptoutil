package com.wuriyanto.wcryptoutil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        FileInputStream privateKeyStream = null;
        FileInputStream publicKeyStream = null;
        try {
            WRSAUtil rsaUtil = new WRSAUtil(WRSAUtil.KEY_SIZE_2KB);
            rsaUtil.generateKeyPair();

            System.out.println(rsaUtil.getPrivateKeyFormat());
            System.out.println(rsaUtil.getPrivateKeyBase64());

            File privateKeyFile = new File("/Users/wuriyanto/Documents/cpp-work/CppEnc/goca/private_key_pkcs8.pem");
            File publicKeyFile = new File("/Users/wuriyanto/Documents/cpp-work/CppEnc/goca/public_key.pem");

            privateKeyStream = new FileInputStream(privateKeyFile);
            publicKeyStream = new FileInputStream(publicKeyFile);

            PrivateKey privateKey = WRSAUtil.loadPrivateKey(privateKeyStream);
            PublicKey publicKey = WRSAUtil.loadPublicKey(publicKeyStream);

            System.out.println("--------------------");

            ByteArrayInputStream privateKeyInputStream = new ByteArrayInputStream(rsaUtil.getPrivateKeyBase64().getBytes());

            WRSAUtil.loadPrivateKey(privateKeyInputStream);

            System.out.println("--------------------");

            System.out.println(WKeyUtil.hexEncode(WKeyUtil.generateRandomSymmetricKey().getEncoded()));

            System.out.println("--------- encryption -----------");

            Key key = WKeyUtil.from("ewd$#128djdyAgbjau&YAnmcbagryt5x");

            String data = "hello world";

            WEncryption wEncryption = new WRSAEncryption(privateKey, publicKey);

            EncryptResult encryptResult = wEncryption.encrypt(data.getBytes());
            System.out.println(encryptResult.getNonce());

            String d = "835b1d3c4d3518d60caed277975b6fae9f97d649397f9add26a01085044b89017bc053bab315d72eb5606b06c5c21b3c358eb78f4ae999d9d4f18330e7facbb182ec99fda0da07310c08f442c48bc7aa2b81683691c320c112ea00b7c33519931ccb4d4d450aee9152ca59f6cbc39855f097839b12577d88c7ac683bb08cc6affd8904532e0d905bd4854fe163b26f9ea500ea7b3ff89b75fdbc1205afa080e5dcc14d60f68624491993f54e9e7c0a6e62cf7c228d9f8c0ab213cd1e82affa9b58cd56702f6d04ab3e2eead98d0ea6fbde1be4b673e8914cb6770dd97aba8d440faf00e700a88e6dc3307977b1ba0797cea27246c5eab46d810b90d5618b5f2338a18b7712e7b51ba1604472de06fc50b96e";
            String n = "c689d716559427d25c8649e3";
            //          8b4308190c509e4f2af17678
            byte[] plainTextBytes = wEncryption.decrypt(encryptResult.getData(), null);
            System.out.println(new String(plainTextBytes));

            System.out.println("--------- signature -----------");

            WDigitalSignature digitalSignature = new WRSADigitalSignature();

            byte[] signature = digitalSignature.sign(privateKey, encryptResult.getData());

            boolean signatureValid = digitalSignature.verify(publicKey, encryptResult.getData(), signature);
            System.out.println(signatureValid);

            System.out.println("---------- digest ----------");

            System.out.println(WDigest.sha256("helloworld".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (privateKeyStream != null)
                    privateKeyStream.close();

                if (publicKeyStream != null)
                    publicKeyStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
