package com.hastanerandevu.beans;

import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.model.PatientTreatmentRelModel;
import com.hastanerandevu.model.TreatmentModel;
import com.hastanerandevu.service.impl.PatientServiceImpl;
import com.hastanerandevu.service.impl.PatientTreatmentRelServiceImpl;
import com.hastanerandevu.service.impl.TreatmentServiceImpl;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "treatment")
@ViewScoped
public class TreatmentBean implements Serializable {
  private static final Logger LOG = Logger.getLogger(TreatmentBean.class);
  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private PatientTreatmentRelServiceImpl patientTreatmentRelService;
  private PatientServiceImpl patientService;
  private TreatmentServiceImpl treatmentService;
  private PatientTreatmentRelModel patientTreatmentRelModel;
  private PatientModel patientModel;

  private boolean treatmentPanel = false;

  private List<PatientTreatmentRelModel> patientTreatments;
  private Map<Long, String> treatments;

  @PostConstruct
  public void init() {
    patientTreatmentRelService = new PatientTreatmentRelServiceImpl();
    patientService = new PatientServiceImpl();
    treatmentService = new TreatmentServiceImpl();
    patientTreatmentRelModel = new PatientTreatmentRelModel();
    patientModel = loginBean.getPatientModel();

    patientTreatments = new ArrayList<>();
    treatments = new LinkedHashMap<>();

    patientTreatments.addAll(patientService.getPatientTreatments(patientModel));

    for(TreatmentModel treatmentModel : treatmentService.findAll()) {
      treatments.put(treatmentModel.getPk(), treatmentModel.getTreatmentName());
    }

    if(patientService.getPatientTreatments(patientModel).size() > 0) {
      treatmentPanel = true;
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }


  /*public String saveTreatment() {
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

  public String deleteTreatment() {
    patientAssayRelService.delete(patientAssayRelModel);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tahlil silindi", null));
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    return "/view/assay?faces-redirect=true";
  }*/
}
