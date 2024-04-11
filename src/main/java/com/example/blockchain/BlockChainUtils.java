package com.example.blockchain;

import java.security.MessageDigest;
import org.apache.logging.log4j.message.Message;

public class BlockChainUtils {
    public static String generateHash (String ... inputValues) {
        try {
            StringBuffer stringBuffer = new StringBuffer();

            for (String inputValue : inputValues) {
                stringBuffer.append(inputValue);
            }

            String input = stringBuffer.toString();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);

                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
