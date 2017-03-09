package com.hastanerandevu.enums;

import com.hastanerandevu.constants.ProjectConstants;
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

  private static final ResourceBundle res = ResourceBundle.getBundle(ProjectConstants.localizationFilePath);

  public String getLocalizedString() {
    return res.getString(name() + ".string");
  }
}
