package com.hastanerandevu.service;

import com.hastanerandevu.model.DiseaseModel;

import java.util.List;

public interface DiseaseService {
  void createDisease (String diseaseName);

  void updateDisease (long id, String diseaseName);

  void deleteDisease (long id);

  DiseaseModel findDisease (long id);

  List<DiseaseModel> getAllDiseases ();
}
