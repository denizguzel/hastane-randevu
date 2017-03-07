package com.hastanerandevu.controller;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.CityDao;
import com.hastanerandevu.model.CityModel;
import com.hastanerandevu.service.CityService;
import com.hastanerandevu.service.impl.CityServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Okan on 7.3.2017.
 */
public class test {
  public static void main(String[] args) {

    CityService cityService = new CityServiceImpl();

    for (CityModel cityModel : cityService.getAllCities()){
      System.out.println(cityModel.getCityName());
    }
  }
}
