package com.hastanerandevu.service;

import com.hastanerandevu.model.AlergyModel;

import java.util.List;

public interface AlergyService {
  void createAlergy (String alergyName);

  void updateAlergy (long id, String alergyName);

  void deleteAlergy (long id);

  AlergyModel findAlergy (long id);

  List<AlergyModel> getAllAlergies ();
}
