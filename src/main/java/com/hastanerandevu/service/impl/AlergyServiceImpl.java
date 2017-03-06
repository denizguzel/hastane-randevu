package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.AlergyDao;
import com.hastanerandevu.dao.impl.AlergyDaoImpl;
import com.hastanerandevu.model.AlergyModel;
import com.hastanerandevu.service.AlergyService;

import java.util.List;

public class AlergyServiceImpl implements AlergyService {
  private AlergyDao alergyDao = new AlergyDaoImpl();

  @Override
  public void createAlergy (String alergyName) {
    alergyDao.createAlergy(alergyName);
  }

  @Override
  public void updateAlergy (long id, String alergyName) {
    alergyDao.updateAlergy(id, alergyName);
  }

  @Override
  public void deleteAlergy (long id) {
    alergyDao.deleteAlergy(id);
  }

  @Override
  public AlergyModel findAlergy (long id) {
    return alergyDao.findAlergy(id);
  }

  @Override
  public List<AlergyModel> getAllAlergies () {
    return alergyDao.getAllAlergies();
  }
}
