package com.hastanerandevu.validation;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.utility.UTF8Control;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("email")
public class EmailValidator implements Validator {

  private Pattern pattern;
  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  public EmailValidator() {
    pattern = Pattern.compile(ProjectConstants.EMAIL_PATTERN);
  }

  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    Matcher matcher = pattern.matcher(value.toString());
    if(!matcher.matches()) {
      FacesMessage msg = new FacesMessage(null, bundle.getString("validation.email.unsuccessful"));
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}