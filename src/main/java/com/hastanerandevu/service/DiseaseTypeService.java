package com.hastanerandevu.service;

import com.hastanerandevu.model.DiseaseTypeModel;

import java.util.List;

public interface DiseaseTypeService {

  void createDiseaseType (String diseaseTypeName);

  void updateDiseaseType (long id, String diseaseTypeName);

  void deleteDiseaseType (long id);

  DiseaseTypeModel findDiseaseType (long id);

  List<DiseaseTypeModel> getAllDiseaseTypes ();
}
