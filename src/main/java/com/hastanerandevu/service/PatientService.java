package com.hastanerandevu.service;

public interface PatientService {
  void createPatient (String firstName, String password);

  void loginPatient (String firstName, String password);
}
