package com.hastanerandevu.dao;

import com.hastanerandevu.model.OptionModel;

import java.util.List;

public interface OptionDao {
  void createOption (String optionText);

  void updateOption (long id, String optionText);

  void deleteOption (long id);

  OptionModel findOption (long id);

  List<OptionModel> getAllOptions ();
}
