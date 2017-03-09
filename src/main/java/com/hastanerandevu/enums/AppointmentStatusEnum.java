package com.hastanerandevu.enums;

import com.hastanerandevu.constants.ProjectConstants;

import java.util.ResourceBundle;

/**
 * Created by Okan on 9.3.2017.
 */
public enum AppointmentStatusEnum {
  RESERVED, NOT_RESERVED;

  private static final ResourceBundle res = ResourceBundle.getBundle(ProjectConstants.localizationFilePath);

  public String getLocalizedString () {
    return res.getString(name() + ".string");
  }
}
