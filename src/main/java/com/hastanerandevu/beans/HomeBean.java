package com.hastanerandevu.beans;

import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.impl.FrequentlyAskedQuestionsServiceImpl;
import com.hastanerandevu.service.impl.OptionServiceImpl;
import com.hastanerandevu.service.impl.SurveyServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "home")
@ViewScoped
public class HomeBean implements Serializable {

  private SurveyServiceImpl surveyService;
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService;
  private OptionServiceImpl optionService;

  private String selectedOption;
  private boolean cookieCheck = false;

  private List<FrequentlyAskedQuestionsModel> askedQuestions;
  private List<SurveyModel> surveys;
  private List<OptionModel> options;

  @PostConstruct
  public void init() {
    surveyService = new SurveyServiceImpl();
    frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();
    optionService = new OptionServiceImpl();

    askedQuestions = new ArrayList<>();
    surveys = new ArrayList<>();
    options = new ArrayList<>();

    askedQuestions.addAll(frequentlyAskedQuestionsService.getAllAskedQuestions());
    surveys.addAll(surveyService.getSurveys());

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    String cookieName = "surveysDone";
    List<Cookie> userCookies = new ArrayList<>();
    Collections.addAll(userCookies, request.getCookies());
    if(userCookies.size() > 0) {
      for(Cookie userCookie : userCookies) {
        if(userCookie.getName().equals(cookieName) && userCookie.getValue().equals("yes")) {
          cookieCheck = true;
        }
      }
    }
  }

  public boolean isCookieCheck() {
    return cookieCheck;
  }

  public void setCookieCheck(boolean cookieCheck) {
    this.cookieCheck = cookieCheck;
  }

  public String getSelectedOption() {
    return selectedOption;
  }

  public void setSelectedOption(String selectedOption) {
    this.selectedOption = selectedOption;
  }

  public SurveyServiceImpl getSurveyService() {
    return surveyService;
  }

  public List<FrequentlyAskedQuestionsModel> getAskedQuestions() {
    return askedQuestions;
  }

  public List<SurveyModel> getSurveys() {
    return surveys;
  }

  public List<OptionModel> getOptions() {
    return options;
  }

  public String answerSurvey() {
    optionService = new OptionServiceImpl();
    surveyService.answerSurvey(optionService.find(Long.parseLong(selectedOption)));
    return "/index?faces-redirect=true";
  }
}
