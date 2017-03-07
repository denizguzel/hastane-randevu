package com.hastanerandevu.dao;

import com.hastanerandevu.model.PoliclinicModel;

import java.util.List;

public interface PoliclinicDao {
  void createPoliclinic (String policlinicName);

  void updatePoliclinic (long id, String policlinicName);

  void deletePoliclinic (long id);

  PoliclinicModel findPoliclinic (long id);

  List<PoliclinicModel> getAllPoliclinics ();
}
