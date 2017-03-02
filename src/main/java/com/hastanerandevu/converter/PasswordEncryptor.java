package com.hastanerandevu.converter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Okan on 2.3.2017.
 */
public class PasswordEncryptor {
  public static String encryptPassword(String password) throws NoSuchAlgorithmException {

    String md5 = null;

    if(null == password) return null;

    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");

      digest.update(password.getBytes(), 0, password.length());

      md5 = new BigInteger(1, digest.digest()).toString(16);

    } catch (NoSuchAlgorithmException e) {

      e.printStackTrace();
    }
    return md5;
  }
}
