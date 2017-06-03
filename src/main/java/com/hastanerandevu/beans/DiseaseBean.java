package com.hastanerandevu.beans;

import com.hastanerandevu.model.DiseaseModel;
import com.hastanerandevu.model.PatientDiseaseRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.DiseaseServiceImpl;
import com.hastanerandevu.service.impl.PatientDiseaseRelServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean(name = "disease")
@ViewScoped
public class DiseaseBean {
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale(), new UTF8Control());

  private PatientDiseaseRelServiceImpl patientDiseaseRelService;
  private DiseaseServiceImpl diseaseService;

  private PatientDiseaseRelModel patientDiseaseRelModel;
  private PatientModel patientModel;

  private String selectedDisease;
  private char diseaseStillPass;

  private List<PatientDiseaseRelModel> patientDiseases;
  private Map<Long, String> diseases;

  @PostConstruct
  public void init() {
    patientDiseaseRelService = new PatientDiseaseRelServiceImpl();
    PatientServiceImpl patientService = new PatientServiceImpl();
    diseaseService = new DiseaseServiceImpl();
    patientDiseaseRelModel = new PatientDiseaseRelModel();
    patientModel = loginBean.getPatientModel();

    patientDiseases = new ArrayList<>();
    diseases = new LinkedHashMap<>();

    patientDiseases.addAll(patientService.getPatientDiseases(patientModel));

    for(DiseaseModel diseaseModel : diseaseService.findAll()) {
      diseases.put(diseaseModel.getPk(), diseaseModel.getDiseaseName());
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public PatientDiseaseRelModel getPatientDiseaseRelModel() {
    return patientDiseaseRelModel;
  }

  public void setPatientDiseaseRelModel(PatientDiseaseRelModel patientDiseaseRelModel) {
    this.patientDiseaseRelModel = patientDiseaseRelModel;
  }

  public String getSelectedDisease() {
    return selectedDisease;
  }

  public void setSelectedDisease(String selectedDisease) {
    this.selectedDisease = selectedDisease;
  }

  public char getDiseaseStillPass() {
    return diseaseStillPass;
  }

  public void setDiseaseStillPass(char diseaseStillPass) {
    this.diseaseStillPass = diseaseStillPass;
  }

  public List<PatientDiseaseRelModel> getPatientDiseases() {
    return patientDiseases;
  }

  public void setPatientDiseases(List<PatientDiseaseRelModel> patientDiseases) {
    this.patientDiseases = patientDiseases;
  }

  public Map<Long, String> getDiseases() {
    return diseases;
  }

  public void setDiseases(Map<Long, String> diseases) {
    this.diseases = diseases;
  }

  public String saveDisease() {
    if(patientDiseaseRelService.patientHaveDisease(patientModel, diseaseService.find(Long.parseLong(selectedDisease)))) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("disease.save.alreadyhave"), null));
    } else {
      patientDiseaseRelModel.setDisease(diseaseService.find(Long.parseLong(selectedDisease)));
      patientDiseaseRelModel.setPatient(patientModel);
      patientDiseaseRelModel.setIsStillPass(diseaseStillPass);
      patientDiseaseRelService.create(patientDiseaseRelModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("disease.save.successful"), null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/disease?faces-redirect=true";
  }

  public String deleteDisease() {
    patientDiseaseRelService.delete(patientDiseaseRelModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("disease.delete.successful"), null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/disease?faces-redirect=true";
  }
}
