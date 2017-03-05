package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.PatientDao;
import com.hastanerandevu.dao.impl.PatientDaoImpl;
import com.hastanerandevu.service.PatientService;

public class PatientServiceImpl implements PatientService {

  PatientDao patientDao = new PatientDaoImpl();

  @Override
  public void createPatient (String firstName, String password) {
    patientDao.createPatient(firstName,password);
  }

  /*@Override
  public void loginPatient (String firstName, String password) {

  }*/
}
