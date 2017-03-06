package com.hastanerandevu.dao;

import com.hastanerandevu.model.DiseaseTypeModel;

import java.util.List;

public interface DiseaseTypeDao {
  void createDiseaseType (String diseaseTypeName);

  void updateDiseaseType (long id, String diseaseTypeName);

  void deleteDiseaseType (long id);

  DiseaseTypeModel findDiseaseType (long id);

  List<DiseaseTypeModel> getAllDiseaseTypes ();
}
