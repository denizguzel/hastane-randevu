package com.hastanerandevu.beans;

import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.service.impl.DoctorServiceImpl;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "doctor")
@ViewScoped
public class DoctorBean implements Serializable {

  private static final Logger LOG = Logger.getLogger(DoctorBean.class);

  @ManagedProperty(value = "#{login}")
  private LoginBean loginBean;

  private DoctorServiceImpl doctorService;
  private DoctorModel doctorModel;

  private int appointmentCount;

  private List<AppointmentModel> appointmentList;

  @PostConstruct
  public void init() {
    doctorService = new DoctorServiceImpl();
    doctorModel = loginBean.getDoctorModel();

    appointmentList = new LinkedList<>();

    for(AppointmentModel appointmentModel : doctorService.getAppointmentHistoryByDoctor(doctorModel)){
      appointmentList.add(appointmentModel);
      appointmentCount++;
    }
  }

  public void setLoginBean(LoginBean loginBean) {
    this.loginBean = loginBean;
  }

  public int getAppointmentCount() {
    return appointmentCount;
  }

  public List<AppointmentModel> getAppointmentList() {
    return appointmentList;
  }

  public void setAppointmentList(List<AppointmentModel> appointmentList) {
    this.appointmentList = appointmentList;
  }
}
