package by.bsuir.service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.SecureRandom;

public class HMAC {

    public byte[] generateKey() {
        byte[] key = new byte[16];

        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);

        return key;
    }

    public byte[] generateHMAC(String message, byte[] key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            return mac.doFinal(message.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMAC-SHA-256 encrypt.",e);
        }
    }

    public String bytesToString(byte[] hmac) {
        return String.format("%032x", new BigInteger(1, hmac));
    }
}
