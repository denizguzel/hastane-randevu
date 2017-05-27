package com.hastanerandevu.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ManagedBean(name = "language")
@ApplicationScoped
public class LanguageBean {
  private String locale = "tr";
  private Map<String, Object> countries;

  @PostConstruct
  public void init() {
    countries = new LinkedHashMap<>();
    countries.put("TR", Locale.forLanguageTag("tr"));
    countries.put("EN", Locale.ENGLISH);
  }

  public Map<String, Object> getCountries() {
    return countries;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public void localeChanged(ValueChangeEvent e) {
    String newLocaleValue = e.getNewValue().toString();

    for(Map.Entry<String, Object> entry : countries.entrySet()) {
      if(entry.getValue().toString().equals(newLocaleValue)) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
      }
    }
  }
}
