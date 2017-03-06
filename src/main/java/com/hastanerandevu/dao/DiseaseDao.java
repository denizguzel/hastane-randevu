package com.hastanerandevu.dao;

import com.hastanerandevu.model.DiseaseModel;

import java.util.List;

public interface DiseaseDao {
  void createDisease (String diseaseName);

  void updateDisease (long id, String diseaseName);

  void deleteDisease (long id);

  DiseaseModel findDisease (long id);

  List<DiseaseModel> getAllDiseases ();
}
