package com.hastanerandevu.dao;

import com.hastanerandevu.model.AssayTypeModel;

import java.util.List;

public interface AssayTypeDao {
  void createAssayType (String assayTypeName);

  void updateAssayType (long id, String assayTypeName);

  void deleteAssayType (long id);

  AssayTypeModel findAssayType (long id);

  List<AssayTypeModel> getAllAssayTypes ();
}
