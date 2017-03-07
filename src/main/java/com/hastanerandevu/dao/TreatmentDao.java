package com.hastanerandevu.dao;

import com.hastanerandevu.model.TreatmentModel;

import java.util.List;

public interface TreatmentDao {
  void createTreatment (String treatmentName);

  void updateTreatment (long id, String treatmentName);

  void deleteTreatment (long id);

  TreatmentModel findTreatment (long id);

  List<TreatmentModel> getAllTreatments ();
}
