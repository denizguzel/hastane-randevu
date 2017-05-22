package com.hastanerandevu.converter;

import java.security.MessageDigest;

public class Encryptor {
  public static String encrypt(String data) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(data.getBytes("UTF-8"));
      StringBuilder hexString = new StringBuilder();

      for(byte aHash : hash) {
        String hex = Integer.toHexString(0xff & aHash);
        if(hex.length() == 1)
          hexString.append('0');
        hexString.append(hex);
      }
      return hexString.toString();
    } catch(Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
