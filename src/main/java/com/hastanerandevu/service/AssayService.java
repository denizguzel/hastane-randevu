package com.hastanerandevu.service;

import com.hastanerandevu.model.AssayModel;

import java.util.List;

public interface AssayService {
  void createAssay (String assayName);

  void updateAssay (long id, String assayName);

  void deleteAssay (long id);

  AssayModel findAssay (long id);

  List<AssayModel> getAllAssays ();
}
