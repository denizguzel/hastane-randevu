package com.hastanerandevu.enums;

import java.util.ResourceBundle;

/**
 * Created by Okan on 9.3.2017.
 */
public enum HospitalTypeEnum {
  PUBLIC_HOSPITAL,
  PRIVATE_HOSPITAL,
  UNIVERSITY_HOSPITAL;

  private static final ResourceBundle res = ResourceBundle.getBundle("com.hastanerandevu.messages");

  public String getLocalizedString() {
    return res.getString(name() + ".string");
  }
}
