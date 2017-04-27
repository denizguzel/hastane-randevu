package com.hastanerandevu.converter;

public class NameConverter {
  private static final String BLANK = " ";

  public static String getName(String firstName, String lastName) {
    return firstName + BLANK + lastName;
  }
}
