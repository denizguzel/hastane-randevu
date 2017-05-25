package com.hastanerandevu.beans;

import com.hastanerandevu.enums.AssayResultEnum;
import com.hastanerandevu.model.AssayModel;
import com.hastanerandevu.model.PatientAssayRelModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.impl.AssayServiceImpl;
import com.hastanerandevu.service.impl.PatientAssayRelServiceImpl;
import com.hastanerandevu.service.impl.PatientServiceImpl;

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

@ManagedBean(name = "assay")
@ViewScoped
public class AssayBean implements Serializable {
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private PatientAssayRelServiceImpl patientAssayRelService;
  private AssayServiceImpl assayService;
  private PatientAssayRelModel patientAssayRelModel;
  private PatientModel patientModel;

  private String selectedAssay;
  private boolean assayPanel = false;
  private AssayResultEnum[] assayResultEnums = AssayResultEnum.values();

  private List<PatientAssayRelModel> patientAssays;
  private Map<Long, String> assays;

  @PostConstruct
  public void init() {
    patientAssayRelService = new PatientAssayRelServiceImpl();
    PatientServiceImpl patientService = new PatientServiceImpl();
    assayService = new AssayServiceImpl();

    patientAssayRelModel = new PatientAssayRelModel();
    patientModel = loginBean.getPatientModel();

    patientAssays = new ArrayList<>();
    assays = new LinkedHashMap<>();

    patientAssays.addAll(patientService.getPatientAssays(patientModel));

    for(AssayModel assayModel : assayService.findAll()) {
      assays.put(assayModel.getPk(), assayModel.getAssayName());
    }

    if(patientAssays.size() > 0) {
      assayPanel = true;
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public PatientAssayRelModel getPatientAssayRelModel() {
    return patientAssayRelModel;
  }

  public void setPatientAssayRelModel(PatientAssayRelModel patientAssayRelModel) {
    this.patientAssayRelModel = patientAssayRelModel;
  }

  public String getSelectedAssay() {
    return selectedAssay;
  }

  public void setSelectedAssay(String selectedAssay) {
    this.selectedAssay = selectedAssay;
  }

  public boolean isAssayPanel() {
    return assayPanel;
  }

  public void setAssayPanel(boolean assayPanel) {
    this.assayPanel = assayPanel;
  }

  public List<PatientAssayRelModel> getPatientAssays() {
    return patientAssays;
  }

  public void setPatientAssays(List<PatientAssayRelModel> patientAssays) {
    this.patientAssays = patientAssays;
  }

  public Map<Long, String> getAssays() {
    return assays;
  }

  public void setAssays(Map<Long, String> assays) {
    this.assays = assays;
  }

  public AssayResultEnum[] getAssayResultEnums() {
    return assayResultEnums;
  }

  public void setAssayResultEnums(AssayResultEnum[] assayResultEnums) {
    this.assayResultEnums = assayResultEnums;
  }

  public String saveAssay() {
    if(patientAssayRelService.patientHaveAssay(patientModel, assayService.find(Long.parseLong(selectedAssay)))) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tahlil zaten kayıtlı", null));
    } else {
      patientAssayRelModel.setAssay(assayService.find(Long.parseLong(selectedAssay)));
      patientAssayRelModel.setPatient(patientModel);
      patientAssayRelService.create(patientAssayRelModel);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tahlil kaydı başarılı", null));
    }
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/assay?faces-redirect=true";
  }

  public String deleteAssay() {
    patientAssayRelService.delete(patientAssayRelModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tahlil silindi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/assay?faces-redirect=true";
  }
}
