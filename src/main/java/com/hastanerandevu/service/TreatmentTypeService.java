package com.hastanerandevu.service;

import com.hastanerandevu.model.TreatmentTypeModel;

import java.util.List;

public interface TreatmentTypeService {

  void createTreatmentType (String treatmentTypeName);

  void updateTreatmentType (long id, String treatmentTypeName);

  void deleteTreatmentType (long id);

  TreatmentTypeModel findTreatmentType (long id);

  List<TreatmentTypeModel> getAllTreatmentTypes ();
}
