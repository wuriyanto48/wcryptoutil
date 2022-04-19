package com.wuriyanto.wcryptoutil;

public class EncryptResult {
    private byte[] data;
    private String nonce;

    public EncryptResult(byte[] data, String nonce) {
        this.data = data;
        this.nonce = nonce;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}
