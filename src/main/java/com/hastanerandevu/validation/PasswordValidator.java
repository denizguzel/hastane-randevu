package com.hastanerandevu.validation;

import com.hastanerandevu.constants.ProjectConstants;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("password")
public class PasswordValidator implements Validator {

  private Pattern pattern = Pattern.compile(ProjectConstants.PASSWORD_PATTERN);

  /*
  (?=.*[0-9]) a digit must occur at least once
  (?=.*[a-z]) a lower case letter must occur at least once
  (?=.*[A-Z]) an upper case letter must occur at least once
  (?=.*[@#$%^&+=]) a special character must occur at least once
  (?=\\S+$) no whitespace allowed in the entire string
  .{8,} at least 8 characters
  */

  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

    String passwordText = value.toString();
    String passwordConfirmText = component.getAttributes().get("otherValue").toString();

    Matcher matcher = pattern.matcher(passwordText);

    if(passwordConfirmText == null) {
      return;
    }

    if(!matcher.matches()) {
      FacesMessage msg = new FacesMessage(null, "Şifrenizi kontrol ediniz");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    } else if(!passwordText.equals(passwordConfirmText)) {
      FacesMessage msg = new FacesMessage(null, "Şifreleriniz eşleşmiyor");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}
