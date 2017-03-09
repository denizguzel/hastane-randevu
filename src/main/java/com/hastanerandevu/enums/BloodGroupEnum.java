package com.hastanerandevu.enums;

import org.codehaus.jackson.annotate.JsonSubTypes;

import java.util.ResourceBundle;

/**
 * Created by Okan on 9.3.2017.
 */
public enum BloodGroupEnum {
  A,
  B,
  AB,
  O;

  private static final ResourceBundle res = ResourceBundle.getBundle("com.hastanerandevu.messages");

  public String getLocalizedString() {
    return res.getString(name() + ".string");
  }
}
