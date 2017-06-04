package com.hastanerandevu.beans;

import com.hastanerandevu.model.AdminModel;
import com.hastanerandevu.model.FrequentlyAskedQuestionsModel;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.model.SurveyModel;
import com.hastanerandevu.service.impl.AdminServiceImpl;
import com.hastanerandevu.service.impl.FrequentlyAskedQuestionsServiceImpl;
import com.hastanerandevu.service.impl.OptionServiceImpl;
import com.hastanerandevu.service.impl.SurveyServiceImpl;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@ManagedBean(name = "admin")
@ViewScoped
public class AdminBean {

  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  private AdminModel adminModel;
  private AdminServiceImpl adminService;
  private SurveyModel surveyModel;
  private OptionModel optionModel;
  private FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel;

  private SurveyServiceImpl surveyService;
  private OptionServiceImpl optionService;
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService;

  private List<FrequentlyAskedQuestionsModel> askedQuestions;
  private List<SurveyModel> surveys;
  private List<OptionModel> options;

  @PostConstruct
  public void init() {
    adminModel = new AdminModel();
    surveyModel = new SurveyModel();
    optionModel = new OptionModel();
    frequentlyAskedQuestionsModel = new FrequentlyAskedQuestionsModel();

    adminService = new AdminServiceImpl();
    surveyService = new SurveyServiceImpl();
    frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();
    optionService = new OptionServiceImpl();

    askedQuestions = new ArrayList<>();
    surveys = new ArrayList<>();
    options = new ArrayList<>();
    for(int i = 0; i < 4; i++)
      options.add(new OptionModel());

    askedQuestions.addAll(frequentlyAskedQuestionsService.getAllAskedQuestions());
    surveys.addAll(surveyService.getSurveys());
  }

  public List<FrequentlyAskedQuestionsModel> getAskedQuestions() {
    return askedQuestions;
  }

  public void setAskedQuestions(List<FrequentlyAskedQuestionsModel> askedQuestions) {
    this.askedQuestions = askedQuestions;
  }

  public List<SurveyModel> getSurveys() {
    return surveys;
  }

  public void setSurveys(List<SurveyModel> surveys) {
    this.surveys = surveys;
  }

  public SurveyModel getSurveyModel() {
    return surveyModel;
  }

  public void setSurveyModel(SurveyModel surveyModel) {
    this.surveyModel = surveyModel;
  }

  public FrequentlyAskedQuestionsModel getFrequentlyAskedQuestionsModel() {
    return frequentlyAskedQuestionsModel;
  }

  public void setFrequentlyAskedQuestionsModel(FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel) {
    this.frequentlyAskedQuestionsModel = frequentlyAskedQuestionsModel;
  }

  public List<OptionModel> getOptions() {
    return options;
  }

  public void setOptions(List<OptionModel> options) {
    this.options = options;
  }

  public void createSurvey() {
    surveyService.createSurvey(surveyModel, options);
  }
}
