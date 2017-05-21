package com.hastanerandevu.beans;

import com.hastanerandevu.model.DiseaseModel;
import com.hastanerandevu.model.PatientDiseaseRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.DiseaseServiceImpl;
import com.hastanerandevu.service.impl.PatientDiseaseRelServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "disease")
@ViewScoped
public class DiseaseBean implements Serializable {
  private static final Logger LOG = Logger.getLogger(DiseaseBean.class);
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private PatientDiseaseRelServiceImpl patientDiseaseRelService;
  private PatientServiceImpl patientService;
  private DiseaseServiceImpl diseaseService;
  private PatientDiseaseRelModel patientDiseaseRelModel;
  private PatientModel patientModel;

  private String selectedDisease;
  private char diseaseStillPass;
  private boolean diseasePanel = false;

  private List<PatientDiseaseRelModel> patientDiseases;
  private Map<Long, String> diseases;

  @PostConstruct
  public void init() {
    patientDiseaseRelService = new PatientDiseaseRelServiceImpl();
    patientService = new PatientServiceImpl();
    diseaseService = new DiseaseServiceImpl();
    patientDiseaseRelModel = new PatientDiseaseRelModel();
    patientModel = loginBean.getPatientModel();

    patientDiseases = new ArrayList<>();
    diseases = new LinkedHashMap<>();

    patientDiseases.addAll(patientService.getPatientDiseases(patientModel));

    for(DiseaseModel diseaseModel : diseaseService.findAll()) {
      diseases.put(diseaseModel.getPk(), diseaseModel.getDiseaseName());
    }

    if(patientDiseases.size() > 0) {
      diseasePanel = true;
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

  public boolean isDiseasePanel() {
    return diseasePanel;
  }

  public void setDiseasePanel(boolean diseasePanel) {
    this.diseasePanel = diseasePanel;
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
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hastalık zaten kayıtlı", null));
    } else {
      patientDiseaseRelModel.setDisease(diseaseService.find(Long.parseLong(selectedDisease)));
      patientDiseaseRelModel.setPatient(patientModel);
      patientDiseaseRelModel.setIsStillPass(diseaseStillPass);
      patientDiseaseRelService.create(patientDiseaseRelModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hastalık kaydı başarılı", null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/disease?faces-redirect=true";
  }

  public String deleteDisease() {
    patientDiseaseRelService.delete(patientDiseaseRelModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hastalık silindi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/disease?faces-redirect=true";
  }
}
