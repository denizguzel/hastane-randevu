package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.PatientDao;
import com.hastanerandevu.dao.impl.PatientDaoImpl;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.PatientService;

import java.util.Date;

public class PatientServiceImpl implements PatientService {

  private PatientDao patientDao = new PatientDaoImpl();

  @Override
  public boolean createPatient (String firstName, String lastName, String password, String tcNumber, Date birthDate, String birthPlace, String email, String phoneNumber, String address, String fatherName, String motherName) {
    return patientDao.createPatient(firstName, lastName, password, tcNumber, birthDate, birthPlace, email, phoneNumber, address, fatherName, motherName);
  }

  @Override
  public boolean loginPatient (String tcNumber, String password) {
    return patientDao.loginPatient(tcNumber, password);
  }

  @Override
  public PatientModel findPatient (long id) {
    return patientDao.findPatient(id);
  }
}
