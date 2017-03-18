package com.hastanerandevu.service;

import com.hastanerandevu.dao.OptionDaoImpl;
import com.hastanerandevu.model.OptionModel;

import java.util.List;

public class OptionServiceImpl implements BaseService<OptionModel> {
  private OptionDaoImpl optionDao = new OptionDaoImpl();

  @Override
  public void create(OptionModel model) {
    optionDao.create(model);
  }

  @Override
  public void update(long id, OptionModel model) {
    optionDao.update(id, model);
  }

  @Override
  public void delete(long id) {
    optionDao.delete(id);
  }

  @Override
  public OptionModel find(long id) {
    return optionDao.find(id);
  }

  @Override
  public List<OptionModel> findAll() {
    return optionDao.findAll();
  }
}
