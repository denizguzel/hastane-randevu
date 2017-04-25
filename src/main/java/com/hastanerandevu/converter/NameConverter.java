package com.hastanerandevu.converter;

/**
 * Created by ouzun on 4/25/2017.
 */
public class NameConverter {
  public static final String BLANK = " ";

  public static String getName(String firstName,String lastName){
    return firstName+BLANK+lastName;
  }
}
