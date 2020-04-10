package com.github.nez;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class HmacSha1Signature {
    Mac mac;
    SecretKeySpec key;
    String signature;

    public HmacSha1Signature(String key){
        createOauthSignature(key);
    }

    private void createOauthSignature(String key){
        this.key = new SecretKeySpec(key.getBytes(),"HmacSha1");
        createMacInstance();
        initializeKey();
        encode();
    }

    public void createMacInstance(){
        try {
            this.mac=Mac.getInstance("HmacSha1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void initializeKey(){
        try {
            this.mac.init(key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public void encode(){
       this.signature= new String(Base64.encodeBase64(mac.doFinal()));
    }

    public String getSignature() {
        return signature;
    }
}
