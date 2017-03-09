package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PatientDaoImpl;

public class PatientServiceImpl {

  private PatientDaoImpl patientDao = new PatientDaoImpl();

  public PatientDaoImpl getPatientDao () {
    return patientDao;
  }
}
