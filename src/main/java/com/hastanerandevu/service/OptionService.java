package com.hastanerandevu.service;

import com.hastanerandevu.model.OptionModel;

import java.util.List;

public interface OptionService {
  void createOption (OptionModel optionModel);

  void updateOption (long id, OptionModel optionModel);

  void deleteOption (long id);

  OptionModel findOption (long id);

  List<OptionModel> getAllOptions ();
}
