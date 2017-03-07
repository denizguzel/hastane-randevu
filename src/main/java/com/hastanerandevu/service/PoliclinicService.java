package com.hastanerandevu.service;

import com.hastanerandevu.model.PoliclinicModel;

import java.util.List;

public interface PoliclinicService {
  void createPoliclinic (String policlinicName);

  void updatePoliclinic (long id, String policlinicName);

  void deletePoliclinic (long id);

  PoliclinicModel findPoliclinic (long id);

  List<PoliclinicModel> getAllPoliclinics ();
}
