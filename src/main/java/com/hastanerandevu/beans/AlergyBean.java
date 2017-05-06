package com.hastanerandevu.beans;

import com.hastanerandevu.model.AlergyModel;
import com.hastanerandevu.model.PatientAlergyRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.AlergyServiceImpl;
import com.hastanerandevu.service.impl.PatientAlergyRelServiceImpl;
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

@ManagedBean(name = "alergy")
@ViewScoped
public class AlergyBean implements Serializable {

  private static final Logger LOG = Logger.getLogger(AlergyBean.class);
  List<PatientAlergyRelModel> patientAlergies;
  PatientAlergyRelModel patientAlergyRelModel;
  PatientModel patientModel;
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;
  private PatientAlergyRelServiceImpl patientAlergyRelService;
  private PatientServiceImpl patientService;
  private AlergyServiceImpl alergyService;
  private String selectedAlergy;

  private char alergyStillPass;
  private boolean alergyPanel = false;

  private Map<Long, String> alergies;

  @PostConstruct
  public void init() {
    patientAlergyRelService = new PatientAlergyRelServiceImpl();
    patientService = new PatientServiceImpl();
    alergyService = new AlergyServiceImpl();

    patientModel = loginBean.getPatientModel();

    patientAlergies = new ArrayList<>();
    patientAlergies.addAll(patientService.getPatientAlergies(patientModel));

    alergies = new LinkedHashMap<>();

    for(AlergyModel alergyModel : alergyService.findAll()) {
      alergies.put(alergyModel.getPk(), alergyModel.getAlergyName());
    }

    if(patientService.getPatientAlergies(patientModel).size() > 0) {
      alergyPanel = true;
    }
  }

  public LoginBean getLoginBean() {
    return loginBean;
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public Map<Long, String> getAlergies() {
    return alergies;
  }

  public void setAlergies(Map<Long, String> alergies) {
    this.alergies = alergies;
  }

  public char getAlergyStillPass() {
    return alergyStillPass;
  }

  public void setAlergyStillPass(char alergyStillPass) {
    this.alergyStillPass = alergyStillPass;
  }

  public boolean isAlergyPanel() {
    return alergyPanel;
  }

  public void setAlergyPanel(boolean alergyPanel) {
    this.alergyPanel = alergyPanel;
  }

  public String getSelectedAlergy() {
    return selectedAlergy;
  }

  public void setSelectedAlergy(String selectedAlergy) {
    this.selectedAlergy = selectedAlergy;
  }

  public PatientModel getPatientModel() {
    return patientModel;
  }

  public void setPatientModel(PatientModel patientModel) {
    this.patientModel = patientModel;
  }

  public List<PatientAlergyRelModel> getPatientAlergies() {
    return patientAlergies;
  }

  public void setPatientAlergies(List<PatientAlergyRelModel> patientAlergies) {
    this.patientAlergies = patientAlergies;
  }

  public String saveAlergy() {

    if(patientAlergyRelService.patientHaveAlergy(patientModel, alergyService.find(Long.parseLong(selectedAlergy)))) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerji zaten kayıtlı", null));
    } else {
      patientAlergyRelModel = new PatientAlergyRelModel();
      patientAlergyRelModel.setAlergy(alergyService.find(Long.parseLong(selectedAlergy)));
      patientAlergyRelModel.setPatient(patientModel);
      patientAlergyRelModel.setIsStillPass(alergyStillPass);
      patientAlergyRelService.create(patientAlergyRelModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerji kaydı başarılı", null));
    }

    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/alergy?faces-redirect=true";

  }

  public String deleteAlergy(PatientAlergyRelModel patientAlergyRelModel) {
    patientAlergyRelService.delete(patientAlergyRelModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerji silindi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/alergy?faces-redirect=true";
  }
}
