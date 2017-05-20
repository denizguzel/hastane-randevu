package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.DoctorDaoImpl;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.service.BaseService;

import java.util.Date;
import java.util.List;

public class DoctorServiceImpl implements BaseService<DoctorModel> {

  private DoctorDaoImpl doctorDao = new DoctorDaoImpl();

  @Override
  public void create(DoctorModel model) {
    doctorDao.create(model);
  }

  @Override
  public void update(DoctorModel model) {
    doctorDao.update(model);
  }

  @Override
  public void delete(DoctorModel model) {
    doctorDao.delete(model);
  }

  @Override
  public DoctorModel find(long id) {
    return doctorDao.find(id);
  }

  @Override
  public List<DoctorModel> findAll() {
    return doctorDao.findAll();
  }

  public DoctorModel loginDoctor(DoctorModel doctorModel) {
    return doctorDao.loginDoctor(doctorModel);
  }

  public List<AppointmentModel> getAppointmentHistoryByDoctor(DoctorModel doctorModel) {
    return doctorDao.getAppointmentHistoryByDoctor(doctorModel);
  }

  public long remainingAppointment(DoctorModel doctorModel) {
    return doctorDao.remainingAppointment(doctorModel);
  }

  public List<AppointmentModel> getAppointmentsNote(DoctorModel doctorModel){
    return doctorDao.getAppointmentsNote(doctorModel);
  }
}
