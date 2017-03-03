package com.hastanerandevu.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator ("passwordValidator")
public class PasswordValidator implements Validator {

  private static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

  /*
  (?=.*[0-9]) a digit must occur at least once
  (?=.*[a-z]) a lower case letter must occur at least once
  (?=.*[A-Z]) an upper case letter must occur at least once
  (?=.*[@#$%^&+=]) a special character must occur at least once
  (?=\\S+$) no whitespace allowed in the entire string
  .{8,} at least 8 characters
  */

  private static Pattern pattern;

  public PasswordValidator () {
    pattern = Pattern.compile(PASSWORD_PATTERN);
  }

  public void validate (FacesContext context, UIComponent component, Object value) throws ValidatorException {

    Matcher matcher = pattern.matcher(value.toString());

    if ( !matcher.matches() ) {
      FacesMessage msg = new FacesMessage("Geçersiz şifre. Lütfen şifrenizi belirtilen formatta giriniz", "Şifreniz en az 1 rakam, 1 küçük harf, 1 büyük harf, 1 özel karakter ve en az 8 haneli olmalıdır.");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}
