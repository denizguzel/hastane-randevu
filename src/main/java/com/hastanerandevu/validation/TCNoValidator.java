package com.hastanerandevu.validation;

import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("tcNumber")
public class TCNoValidator implements Validator {
  private static final Logger LOG = Logger.getLogger(TCNoValidator.class);

  private static boolean isValidTckn(String tckn) {
    int totalOdd  = 0;
    int totalEven = 0;
    int val, total, lastDigit, check;
    try {
      if(tckn.length() == 11) {
        for(int i = 0; i < 9; i++) {
          val = Integer.valueOf(tckn.substring(i, i + 1));
          if(i % 2 == 0) {
            totalOdd += val;
          } else {
            totalEven += val;
          }
        }
        total = totalOdd + totalEven + Integer.valueOf(tckn.substring(9, 10));
        lastDigit = total % 10;
        if(tckn.substring(10).equals(String.valueOf(lastDigit))) {
          check = (totalOdd * 7 - totalEven) % 10;
          if(tckn.substring(9, 10).equals(String.valueOf(check))) {
            return true;
          }
        }
      }
    } catch(Exception e) {
      LOG.info(e.getMessage());
    }
    return false;
  }

  public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
    if(!isValidTckn(value.toString())) {
      FacesMessage msg = new FacesMessage("TC No doğrulaması hatalı.", "TC No geçerli değil.");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}
