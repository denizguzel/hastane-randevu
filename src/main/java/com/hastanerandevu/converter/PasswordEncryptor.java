package com.hastanerandevu.converter;

import java.security.MessageDigest;

public class PasswordEncryptor {
  public static String encryptPassword(String password) {
    try {
      MessageDigest digest    = MessageDigest.getInstance("SHA-256");
      byte[]        hash      = digest.digest(password.getBytes("UTF-8"));
      StringBuilder hexString = new StringBuilder();

      for(byte aHash : hash) {
        String hex = Integer.toHexString(0xff & aHash);
        if(hex.length() == 1)
          hexString.append('0');
        hexString.append(hex);
      }

      return hexString.toString();
    } catch(Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
