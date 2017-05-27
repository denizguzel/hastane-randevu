package com.hastanerandevu.beans;

import com.hastanerandevu.model.AlergyModel;
import com.hastanerandevu.model.PatientAlergyRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.AlergyServiceImpl;
import com.hastanerandevu.service.impl.PatientAlergyRelServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.utility.UTF8Control;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "alergy")
@ViewScoped
public class AlergyBean implements Serializable {
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  ResourceBundle bundle = ResourceBundle.getBundle("com.hastanerandevu.messages",new UTF8Control());

  private PatientAlergyRelServiceImpl patientAlergyRelService;
  private AlergyServiceImpl alergyService;

  private PatientAlergyRelModel patientAlergyRelModel;
  private PatientModel patientModel;

  private String selectedAlergy;
  private char alergyStillPass;
  private boolean alergyPanel = false;

  private List<PatientAlergyRelModel> patientAlergies;
  private Map<Long, String> alergies;

  @PostConstruct
  public void init() {
    patientAlergyRelService = new PatientAlergyRelServiceImpl();
    PatientServiceImpl patientService = new PatientServiceImpl();
    alergyService = new AlergyServiceImpl();
    patientAlergyRelModel = new PatientAlergyRelModel();
    patientModel = loginBean.getPatientModel();

    patientAlergies = new ArrayList<>();
    alergies = new LinkedHashMap<>();

    patientAlergies.addAll(patientService.getPatientAlergies(patientModel));

    for(AlergyModel alergyModel : alergyService.findAll()) {
      alergies.put(alergyModel.getPk(), alergyModel.getAlergyName());
    }

    if(patientAlergies.size() > 0) {
      alergyPanel = true;
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public PatientAlergyRelModel getPatientAlergyRelModel() {
    return patientAlergyRelModel;
  }

  public void setPatientAlergyRelModel(PatientAlergyRelModel patientAlergyRelModel) {
    this.patientAlergyRelModel = patientAlergyRelModel;
  }

  public String getSelectedAlergy() {
    return selectedAlergy;
  }

  public void setSelectedAlergy(String selectedAlergy) {
    this.selectedAlergy = selectedAlergy;
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

  public List<PatientAlergyRelModel> getPatientAlergies() {
    return patientAlergies;
  }

  public void setPatientAlergies(List<PatientAlergyRelModel> patientAlergies) {
    this.patientAlergies = patientAlergies;
  }

  public Map<Long, String> getAlergies() {
    return alergies;
  }

  public void setAlergies(Map<Long, String> alergies) {
    this.alergies = alergies;
  }

  public String saveAlergy() {
    if(patientAlergyRelService.patientHaveAlergy(patientModel, alergyService.find(Long.parseLong(selectedAlergy)))) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,bundle.getString("alergy.save.alreadyhave") , null));
    } else {
      patientAlergyRelModel.setAlergy(alergyService.find(Long.parseLong(selectedAlergy)));
      patientAlergyRelModel.setPatient(patientModel);
      patientAlergyRelModel.setIsStillPass(alergyStillPass);
      patientAlergyRelService.create(patientAlergyRelModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("alergy.save.successful"), null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/alergy?faces-redirect=true";
  }

  public String deleteAlergy() {
    patientAlergyRelService.delete(patientAlergyRelModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, bundle.getString("alergy.delete.successful"), null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/alergy?faces-redirect=true";
  }
}
