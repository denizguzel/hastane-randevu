package com.hastanerandevu.service;

import com.hastanerandevu.dao.PatientDaoImpl;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.PatientModel;

import java.util.Date;
import java.util.List;

public class PatientServiceImpl implements BaseService<PatientModel> {

  private PatientDaoImpl patientDao = new PatientDaoImpl();

  public PatientModel loginPatient(PatientModel patientModel) {
    return patientDao.loginPatient(patientModel);
  }

  @Override
  public void create(PatientModel patientModel) {
    patientDao.create(patientModel);
  }

  @Override
  public void update(long id, PatientModel patientModel) {
    patientDao.update(id, patientModel);
  }

  @Override
  public void delete(long id) {
    patientDao.delete(id);
  }

  @Override
  public PatientModel find(long id) {
    return patientDao.find(id);
  }

  @Override
  public List<PatientModel> findAll() {
    return patientDao.findAll();
  }

  public long getNumberOfPatientAppointments(PatientModel patientModel) {
    return patientDao.getNumberOfPatientAppointments(patientModel);
  }

  public boolean haveAnAppointmentForThatDay(PatientModel patientModel, Date date) {
    return patientDao.haveAnAppointmentForThatDay(patientModel, date);
  }

  public List<AppointmentModel> getAppointmentHistory(PatientModel patientModel) {
    return patientDao.getAppointmentHistory(patientModel);
  }

  public boolean haveUserRegistration(PatientModel patientModel) {
    return patientDao.haveUserRegistration(patientModel);
  }

  public PatientModel getUserByEmail(PatientModel patientModel) {
    return patientDao.getUserByEmail(patientModel);
  }
}
