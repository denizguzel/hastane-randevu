package com.hastanerandevu.service;

import com.hastanerandevu.model.OptionModel;

import java.util.List;

public interface OptionService {
  void createOption (String optionText);

  void updateOption (long id, String optionText);

  void deleteOption (long id);

  OptionModel findOption (long id);

  List<OptionModel> getAllOptions ();
}
