package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.OptionDaoImpl;
import com.hastanerandevu.model.OptionModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class OptionServiceImpl implements BaseService<OptionModel> {
  private OptionDaoImpl optionDao = new OptionDaoImpl();

  @Override
  public void create(OptionModel model) {
    optionDao.create(model);
  }

  @Override
  public void update(OptionModel model) {
    optionDao.update(model);
  }

  @Override
  public void delete(OptionModel model) {
    optionDao.delete(model);
  }

  @Override
  public OptionModel find(long id) {
    return optionDao.find(id);
  }

  @Override
  public List<OptionModel> findAll() {
    return optionDao.findAll();
  }


  public Integer getOptionRate(OptionModel option){
    int i = 0;
    for (OptionModel optionModel : option.getSurvey().getOptionModels()){
      i += optionModel.getCount();
    }
    return (int)((option.getCount() * 100.0f) / i);
  }
}
