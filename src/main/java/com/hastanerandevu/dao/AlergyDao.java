package com.hastanerandevu.dao;

import com.hastanerandevu.model.AlergyModel;

import java.util.List;

public interface AlergyDao {
  void createAlergy (String alergyName);

  void updateAlergy (long id, String alergyName);

  void deleteAlergy (long id);

  AlergyModel findAlergy (long id);

  List<AlergyModel> getAllAlergies ();
}
