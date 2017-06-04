package com.hastanerandevu.beans;

import com.hastanerandevu.model.*;
import com.hastanerandevu.service.impl.*;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
  private SurveyModel surveyModel;
  private OptionModel optionModel;
  private FrequentlyAskedQuestionsModel frequentlyAskedQuestionsModel;
  private ReviewsAboutDoctorsModel reviewsAboutDoctorsModel;

  private AdminServiceImpl adminService;
  private SurveyServiceImpl surveyService;
  private OptionServiceImpl optionService;
  private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsService;
  private PatientServiceImpl patientService;
  private AppointmentServiceImpl appointmentService;
  private ReviewsAboutDoctorsServiceImpl reviewsAboutDoctorsService;

  private List<FrequentlyAskedQuestionsModel> askedQuestions;
  private List<SurveyModel> surveys;
  private List<OptionModel> options;
  private List<ReviewsAboutDoctorsModel> doctorReviews;

  @PostConstruct
  public void init() {
    adminModel = new AdminModel();
    surveyModel = new SurveyModel();
    optionModel = new OptionModel();
    frequentlyAskedQuestionsModel = new FrequentlyAskedQuestionsModel();
    reviewsAboutDoctorsModel = new ReviewsAboutDoctorsModel();

    adminService = new AdminServiceImpl();
    surveyService = new SurveyServiceImpl();
    frequentlyAskedQuestionsService = new FrequentlyAskedQuestionsServiceImpl();
    optionService = new OptionServiceImpl();
    patientService = new PatientServiceImpl();
    appointmentService = new AppointmentServiceImpl();
    reviewsAboutDoctorsService = new ReviewsAboutDoctorsServiceImpl();

    askedQuestions = new ArrayList<>();
    surveys = new ArrayList<>();
    options = new ArrayList<>();

    for(int i = 0; i < 4; i++)
      options.add(new OptionModel());

//    doctorReviews.addAll(reviewsAboutDoctorsService.findAll());
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

  public SurveyServiceImpl getSurveyService() {
    return surveyService;
  }

  public List<ReviewsAboutDoctorsModel> getDoctorReviews() {
    return doctorReviews;
  }

  public void setDoctorReviews(List<ReviewsAboutDoctorsModel> doctorReviews) {
    this.doctorReviews = doctorReviews;
  }

  // Functions
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

  public String commentApprove(ReviewsAboutDoctorsModel review) {
    reviewsAboutDoctorsService.update(review);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yorum Onaylandı", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/comments?faces-redirect=true";
  }

  public String commentReject(ReviewsAboutDoctorsModel review) {
    reviewsAboutDoctorsService.update(review);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Yorum Reddedildi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/comments?faces-redirect=true";
  }

  public String faqSave() {
    frequentlyAskedQuestionsService.create(frequentlyAskedQuestionsModel);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("label.questionSave"), null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/faq?faces-redirect=true";
  }

  public String faqDelete() {
    frequentlyAskedQuestionsService.delete(frequentlyAskedQuestionsModel);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("label.questionDelete"), null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/faq?faces-redirect=true";
  }

  public String faqUpdate() {
    frequentlyAskedQuestionsService.update(frequentlyAskedQuestionsModel);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("label.questionUpdate"), null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/faq?faces-redirect=true";
  }
}
