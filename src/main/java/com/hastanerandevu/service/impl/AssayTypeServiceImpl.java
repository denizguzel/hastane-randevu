package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.AssayTypeDao;
import com.hastanerandevu.dao.impl.AssayTypeDaoImpl;
import com.hastanerandevu.model.AssayTypeModel;
import com.hastanerandevu.service.AssayTypeService;

import java.util.List;

public class AssayTypeServiceImpl implements AssayTypeService {
  private AssayTypeDao assayTypeDao = new AssayTypeDaoImpl();

  @Override
  public void createAssayType (String assayTypeName) {
    assayTypeDao.createAssayType(assayTypeName);
  }

  @Override
  public void updateAssayType (long id, String assayTypeName) {
    assayTypeDao.updateAssayType(id, assayTypeName);
  }

  @Override
  public void deleteAssayType (long id) {
    assayTypeDao.deleteAssayType(id);
  }

  @Override
  public AssayTypeModel findAssayType (long id) {
    return assayTypeDao.findAssayType(id);
  }

  @Override
  public List<AssayTypeModel> getAllAssayTypes () {
    return assayTypeDao.getAllAssayTypes();
  }
}
