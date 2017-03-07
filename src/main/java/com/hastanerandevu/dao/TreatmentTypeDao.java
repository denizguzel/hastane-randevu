package com.hastanerandevu.dao;

import com.hastanerandevu.model.TreatmentTypeModel;

import java.util.List;

public interface TreatmentTypeDao {
  void createTreatmentType (String treatmentTypeName);

  void updateTreatmentType (long id, String treatmentTypeName);

  void deleteTreatmentType (long id);

  TreatmentTypeModel findTreatmentType (long id);

  List<TreatmentTypeModel> getAllTreatmentTypes ();
}
