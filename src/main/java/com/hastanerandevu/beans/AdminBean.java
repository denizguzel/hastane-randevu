package com.hastanerandevu.beans;

import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.*;
import com.hastanerandevu.utility.SessionUtils;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

@ManagedBean(name = "admin")
@ViewScoped
public class AdminBean {

  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  private AdminModel adminModel;
  private SurveyModel surveyModel;
  private OptionModel optionModel;
  private FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel;

  private AdminServiceImpl adminService;
  private SurveyServiceImpl surveyService;
  private OptionServiceImpl optionService;
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService;
  private PatientServiceImpl patientService;
  private AppointmentServiceImpl appointmentService;

  private List<FrequentlyAskedQuestionsModel> askedQuestions;
  private List<SurveyModel> surveys;
  private List<OptionModel> options;
  private List<AppointmentModel> appointments;

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
    patientService = new PatientServiceImpl();
    appointmentService = new AppointmentServiceImpl();

    askedQuestions = new ArrayList<>();
    surveys = new ArrayList<>();
    options = new ArrayList<>();
    if(SessionUtils.getSession().getAttribute("userType").equals("admib")) {
      for(AppointmentModel appointmentModel : appointmentService.findAll()) {
        if(appointmentModel.getPatient() != null)
          appointments.addAll((Collection<? extends AppointmentModel>) appointmentModel);
      }
    }

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

  public PatientServiceImpl getPatientService() {
    return patientService;
  }

  public List<AppointmentModel> getAppointments() {
    return appointments;
  }

  public SurveyServiceImpl getSurveyService() {
    return surveyService;
  }

  private void clearListComponentsWithChange(List... lists) {
    for(List list : lists) {
      list.clear();
    }
  }

  public void resetSurvey() {
    surveyModel = new SurveyModel();
    clearListComponentsWithChange(options);
    for(int i = 0; i < 4; i++)
      options.add(new OptionModel());
  }

  public String createSurvey() {
    surveyService.createSurvey(surveyModel, options);
    clearListComponentsWithChange(options);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Anket Oluşturuldu", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/survey?faces-redirect=true";
  }

  public String updateSurvey() {
    surveyService.updateSurvey(surveyModel, options);
    clearListComponentsWithChange(options);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Anket Güncellendi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/survey?faces-redirect=true";
  }

  public String deleteSurvey() {
    surveyService.deleteSurvey(surveyModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Anket Silindi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/survey?faces-redirect=true";
  }
}
