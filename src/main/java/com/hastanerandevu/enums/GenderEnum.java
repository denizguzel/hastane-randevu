package com.hastanerandevu.enums;

import java.util.ResourceBundle;

/**
 * Created by Okan on 9.3.2017.
 */
public enum GenderEnum {
  MALE,
  FEMALE;

  private static final ResourceBundle res = ResourceBundle.getBundle("com.hastanerandevu.messages");

  public String getLocalizedString() {
    return res.getString(name() + ".string");
  }
}
