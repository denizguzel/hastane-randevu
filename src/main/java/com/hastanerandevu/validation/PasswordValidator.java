package com.hastanerandevu.validation;

import com.hastanerandevu.constants.ProjectConstants;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("password")
public class PasswordValidator implements Validator {

  private static Pattern pattern = Pattern.compile(ProjectConstants.PASSWORD_PATTERN);

  /*
  (?=.*[0-9]) a digit must occur at least once
  (?=.*[a-z]) a lower case letter must occur at least once
  (?=.*[A-Z]) an upper case letter must occur at least once
  (?=.*[@#$%^&+=]) a special character must occur at least once
  (?=\\S+$) no whitespace allowed in the entire string
  .{8,} at least 8 characters
  */

  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

    String  password                 = (String) value;
    UIInput passwordConfirmComponent = (UIInput) component.getAttributes().get("passwordConfirm");
    String  passwordConfirm          = passwordConfirmComponent.getSubmittedValue().toString();

    Matcher matcher = pattern.matcher(password);

    if(password == null || password.isEmpty() || passwordConfirm == null || passwordConfirm.isEmpty()) {
      return;
    }

    if(!matcher.matches()) {
      FacesMessage msg = new FacesMessage("Geçersiz şifre. Lütfen şifrenizi belirtilen formatta giriniz", "Şifreniz en az 1 rakam, 1 küçük harf, 1 büyük harf, 1 özel karakter ve en az 8 haneli olmalıdır.");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    } else if(!password.equals(passwordConfirm)) {
      passwordConfirmComponent.setValid(false);
      FacesMessage msg = new FacesMessage("Şifreleriniz eşleşmiyor", null);
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}
