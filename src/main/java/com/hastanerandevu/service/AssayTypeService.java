package com.hastanerandevu.service;

import com.hastanerandevu.model.AssayTypeModel;

import java.util.List;

public interface AssayTypeService {
  void createAssayType (String assayTypeName);

  void updateAssayType (long id, String assayTypeName);

  void deleteAssayType (long id);

  AssayTypeModel findAssayType (long id);

  List<AssayTypeModel> getAllAssayTypes ();
}
