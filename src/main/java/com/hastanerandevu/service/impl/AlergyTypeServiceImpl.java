package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.AlergyTypeDao;
import com.hastanerandevu.dao.impl.AlergyTypeDaoImpl;
import com.hastanerandevu.model.AlergyTypeModel;
import com.hastanerandevu.service.AlergyTypeService;

import java.util.List;

public class AlergyTypeServiceImpl implements AlergyTypeService {
  private AlergyTypeDao alergyTypeDao = new AlergyTypeDaoImpl();

  @Override
  public void createAlergyType (String alergyTypeName) {
    alergyTypeDao.createAlergyType(alergyTypeName);
  }

  @Override
  public void updateAlergyType (long id, String alergyTypeName) {
    alergyTypeDao.updateAlergyType(id, alergyTypeName);
  }

  @Override
  public void deleteAlergyType (long id) {
    alergyTypeDao.deleteAlergyType(id);
  }

  @Override
  public AlergyTypeModel findAlergyType (long id) {
    return alergyTypeDao.findAlergyType(id);
  }

  @Override
  public List<AlergyTypeModel> getAllAlergyTypes () {
    return alergyTypeDao.getAllAlergyTypes();
  }
}
