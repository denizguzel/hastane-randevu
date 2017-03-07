package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.AssayDao;
import com.hastanerandevu.dao.impl.AssayDaoImpl;
import com.hastanerandevu.model.AssayModel;
import com.hastanerandevu.service.AssayService;

import java.util.List;

public class AssayServiceImpl implements AssayService {
  private AssayDao assayDao = new AssayDaoImpl();

  @Override
  public void createAssay (String assayName) {
    assayDao.createAssay(assayName);
  }

  @Override
  public void updateAssay (long id, String assayName) {
    assayDao.updateAssay(id, assayName);
  }

  @Override
  public void deleteAssay (long id) {
    assayDao.deleteAssay(id);
  }

  @Override
  public AssayModel findAssay (long id) {
    return assayDao.findAssay(id);
  }

  @Override
  public List<AssayModel> getAllAssays () {
    return assayDao.getAllAssays();
  }
}
