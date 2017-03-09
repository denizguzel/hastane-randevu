package com.hastanerandevu.enums;

import com.hastanerandevu.constants.ProjectConstants;

import java.util.ResourceBundle;

public enum BloodGroupEnum {
  A, B, AB, O;

  private static final ResourceBundle res = ResourceBundle.getBundle(ProjectConstants.localizationFilePath);

  public String getLocalizedString () {
    return res.getString(name() + ".string");
  }
}
