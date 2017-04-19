package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientDaoImpl;
import com.hastanerandevu.model.*;
import com.hastanerandevu.service.BaseService;

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
  public void update(PatientModel patientModel) {
    patientDao.update(patientModel);
  }

  @Override
  public void delete(PatientModel patientModel) {
    patientDao.delete(patientModel);
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

  public PatientModel getUserByEmail(String email) {
    return patientDao.getUserByEmail(email);
  }

  public boolean changingPasswordIsAvailable(PatientModel patientModel) {
    return patientDao.changingPasswordIsAvailable(patientModel);
  }

  public List<PatientTreatmentRelModel> getPatientTreatments(PatientModel patientModel) {
    return patientDao.getPatientTreatments(patientModel);
  }

  public List<PatientAlergyRelModel> getPatientAlergies(PatientModel patientModel) {
    return patientDao.getPatientAlergies(patientModel);
  }

  public List<PatientAssayRelModel> getPatientAssays(PatientModel patientModel) {
    return patientDao.getPatientAssays(patientModel);
  }

  public List<PatientDiseaseRelModel> getPatientDiseases(PatientModel patientModel) {
    return patientDao.getPatientDiseases(patientModel);
  }


}
