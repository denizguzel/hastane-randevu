package com.hastanerandevu.dao;

import java.util.Date;

public interface PatientDao {
  boolean createPatient (String firstName, String lastName, String password, String tcNumber, Date birthDate, String birthPlace, String email, String phoneNumber, String address, String fatherName, String motherName);

  boolean loginPatient (String tcNumber, String password);

}
