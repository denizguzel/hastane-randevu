package com.hastanerandevu.service;

import com.hastanerandevu.model.PatientModel;

import java.util.Date;
import java.util.List;

public interface PatientService {
  boolean loginPatient (PatientModel patientModel);

  void createPatient(PatientModel patientModel);

  void updatePatient (long id, PatientModel patientModel);

  void deletePatient (long id);

  PatientModel findPatient (long id);

  List<PatientModel> getAllPatients ();
}
