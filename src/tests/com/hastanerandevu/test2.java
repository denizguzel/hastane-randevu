package com.hastanerandevu;

import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.service.CityService;
import com.hastanerandevu.service.impl.CityServiceImpl;

public class test2 {
  public static void main (String[] args) {

    CityService cityService = new CityServiceImpl();

    for ( CityModel cityModel : cityService.getAllCities() ) {
      System.out.println(cityModel.getCityName());
    }
  }
}
