package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.OptionDao;
import com.hastanerandevu.dao.impl.OptionDaoImpl;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.service.OptionService;

import java.util.List;

public class OptionServiceImpl implements OptionService {
  private OptionDao optionDao = new OptionDaoImpl();

  @Override
  public void createOption (String optionText) {
    optionDao.createOption(optionText);
  }

  @Override
  public void updateOption (long id, String optionText) {
    optionDao.updateOption(id, optionText);
  }

  @Override
  public void deleteOption (long id) {
    optionDao.deleteOption(id);
  }

  @Override
  public OptionModel findOption (long id) {
    return optionDao.findOption(id);
  }

  @Override
  public List<OptionModel> getAllOptions () {
    return optionDao.getAllOptions();
  }
}
