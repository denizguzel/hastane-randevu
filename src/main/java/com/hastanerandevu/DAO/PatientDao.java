package com.hastanerandevu.dao;

import com.hastanerandevu.model.PatientModel;

public interface PatientDao {
  PatientModel createPatient (String username, String password);

  //PatientModel loginPatient (String firstName, String password);
}
