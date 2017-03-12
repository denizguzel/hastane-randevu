package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.OptionDao;
import com.hastanerandevu.dao.impl.OptionDaoImpl;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.service.OptionService;

import java.util.List;

public class OptionServiceImpl implements OptionService {
  private OptionDaoImpl optionDao = new OptionDaoImpl();

  public void createOption (OptionModel optionModel) {
    optionDao.create(optionModel);
  }

  public void updateOption (long id, OptionModel optionModel) {
    optionDao.update(id, optionModel);
  }

  public void deleteOption (long id) {
    optionDao.delete(id);
  }

  public OptionModel findOption (long id) {
    return optionDao.find(id);
  }

  public List<OptionModel> getAllOptions () {
    return optionDao.findAll();
  }
}
