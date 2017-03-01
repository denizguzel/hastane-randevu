package com.hastanerandevu.validation;

import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Okan on 1.3.2017.
 */
public class TCNoValidator implements Validator {
    private static final Logger LOG = Logger.getLogger(TCNoValidator.class);

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (!isValidTckn(value.toString())){
            FacesMessage msg = new FacesMessage("TC Number validation failed.", "Invalid TC Number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    private static boolean isValidTckn(String tckn) {
        try {
            String tmp = tckn.toString();

            if (tmp.length() == 11) {
                int totalOdd = 0;

                int totalEven = 0;

                for (int i = 0; i < 9; i++) {
                    int val = Integer.valueOf(tmp.substring(i, i + 1));

                    if (i % 2 == 0) {
                        totalOdd += val;
                    } else {
                        totalEven += val;
                    }
                }

                int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));

                int lastDigit = total % 10;

                if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
                    int check = (totalOdd * 7 - totalEven) % 10;

                    if (tmp.substring(9, 10).equals(String.valueOf(check))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }

        return false;
    }
}
