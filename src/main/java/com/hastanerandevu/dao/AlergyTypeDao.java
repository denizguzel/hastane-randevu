package com.hastanerandevu.dao;

import com.hastanerandevu.model.AlergyTypeModel;

import java.util.List;

public interface AlergyTypeDao {
  void createAlergyType (String alergyTypeName);

  void updateAlergyType (long id, String alergyTypeName);

  void deleteAlergyType (long id);

  AlergyTypeModel findAlergyType (long id);

  List<AlergyTypeModel> getAllAlergyTypes ();
}
