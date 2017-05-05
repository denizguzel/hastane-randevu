package com.hastanerandevu.beans;

import com.hastanerandevu.model.AlergyModel;
import com.hastanerandevu.model.PatientAlergyRelModel;
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

  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private PatientAlergyRelServiceImpl patientAlergyRelService;
  private PatientServiceImpl patientService;
  private AlergyServiceImpl alergyService;
  private AlergyModel alergyModel;
  private PatientAlergyRelModel patientAlergyRelModel;

  private char alergyStillPass;
  private boolean alergyPanel = false;

  private Map<Long, String> alergies;
  private List<PatientAlergyRelModel> patientAlergyList;

  @PostConstruct
  public void init() {
    patientAlergyRelService = new PatientAlergyRelServiceImpl();
    patientService = new PatientServiceImpl();
    alergyService = new AlergyServiceImpl();

    alergyModel = new AlergyModel();
    patientAlergyRelModel = new PatientAlergyRelModel();

    alergies = new LinkedHashMap<>();
    patientAlergyList = new ArrayList<>();

    patientAlergyRelModel.setPatient(loginBean.getPatientModel());

    for(AlergyModel alergyModel : alergyService.findAll()) {
      alergies.put(alergyModel.getPk(), alergyModel.getAlergyName());
    }

    patientAlergyList.addAll(patientService.getPatientAlergies(loginBean.getPatientModel()));
    if (patientAlergyList.size() > 0) {
      alergyPanel = true;
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public AlergyModel getAlergyModel() {
    return alergyModel;
  }

  public void setAlergyModel(AlergyModel alergyModel) {
    this.alergyModel = alergyModel;
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

  public List<PatientAlergyRelModel> getPatientAlergyList() {
    return patientAlergyList;
  }

  public void setPatientAlergyList(List<PatientAlergyRelModel> patientAlergyList) {
    this.patientAlergyList = patientAlergyList;
  }

  public boolean isAlergyPanel() {
    return alergyPanel;
  }

  public void setAlergyPanel(boolean alergyPanel) {
    this.alergyPanel = alergyPanel;
  }

  public String saveAlergy() {
    patientAlergyRelModel.setAlergy(alergyModel);
    patientAlergyRelModel.setIsStillPass(alergyStillPass);

    if(patientAlergyRelService.find(patientAlergyRelModel.getPk()) != null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerji zaten kayıtlı", null));
    } else {
      patientAlergyRelService.create(patientAlergyRelModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerji kaydı başarılı", null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/alergy?faces-redirect=true";
  }

  public String deleteAlergy(PatientAlergyRelModel patientAlergyRelModel) {
    patientAlergyRelService.delete(patientAlergyRelService.find(patientAlergyRelModel.getPk()));
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerji silindi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/alergy?faces-redirect=true";
  }
}
