package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientDaoImpl;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

  private PatientDaoImpl patientDao = new PatientDaoImpl();

  @Override
  public boolean loginPatient(PatientModel patientModel) {
    return patientDao.loginPatient(patientModel);
  }

  @Override
  public void createPatient(PatientModel patientModel) {
    patientDao.create(patientModel);
  }

  @Override
  public void updatePatient(long id, PatientModel patientModel) {
    patientDao.update(id,patientModel);
  }

  @Override
  public void deletePatient(long id) {
    deletePatient(id);
  }

  @Override
  public PatientModel findPatient(long id) {
    return patientDao.find(id);
  }

  @Override
  public List<PatientModel> getAllPatients() {
    return patientDao.findAll();
  }
}
