package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.PoliclinicDao;
import com.hastanerandevu.dao.impl.PoliclinicDaoImpl;
import com.hastanerandevu.model.PoliclinicModel;
import com.hastanerandevu.service.PoliclinicService;

import java.util.List;

public class PoliclinicServiceImpl implements PoliclinicService {
  private PoliclinicDao policlinicDao = new PoliclinicDaoImpl();

  @Override
  public void createPoliclinic (String policlinicName) {
    policlinicDao.createPoliclinic(policlinicName);
  }

  @Override
  public void updatePoliclinic (long id, String policlinicName) {
    policlinicDao.updatePoliclinic(id, policlinicName);
  }

  @Override
  public void deletePoliclinic (long id) {
    policlinicDao.deletePoliclinic(id);
  }

  @Override
  public PoliclinicModel findPoliclinic (long id) {
    return policlinicDao.findPoliclinic(id);
  }

  @Override
  public List<PoliclinicModel> getAllPoliclinics () {
    return policlinicDao.getAllPoliclinics();
  }
}
