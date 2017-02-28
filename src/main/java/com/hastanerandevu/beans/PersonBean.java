package com.hastanerandevu.beans;

import com.hastanerandevu.DAO.LoginDAO;
import com.hastanerandevu.service.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean (name = "person")
@SessionScoped
public class PersonBean implements Serializable {
  private static final long serialVersionUID = 1094801825228386363L;
  private String username;
  private String password;

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String validateUsernamePassword () {
    boolean valid = LoginDAO.validate(username, password);
    if ( valid ) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("username", username);
      return "view/dashboard?faces-redirect=true";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and Password"));
      return "/index?faces-redirect=true";
    }
  }

  public String logout () {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "/index?faces-redirect=true";
  }

}