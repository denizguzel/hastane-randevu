package com.hastanerandevu;

import com.hastanerandevu.converter.Encryptor;

/**
 * Created by Okan on 14.3.2017.
 */
public class test {


  public static void main(String[] args) {

    /*long id = 4;

    PatientDaoImpl patientDao = new PatientDaoImpl();

    PatientModel patientModel = new PatientModel();

    patientModel.setTcNumber("10865823058");
    patientModel.setPassword("135Okan246+.+");

    if (patientDao.loginPatient(patientModel) != null){
      System.out.println("BASARILI");
    }
    else{
      System.out.println("BASARISIZ");
    }*/

    /*CityServiceImpl cityService = new CityServiceImpl();
    CityModel cityModel = cityService.find(1);
    for (DistrictModel districtModel : cityService.getAllDistrictsByCity(cityModel)){
      System.out.println(districtModel.getDistrictName());
    }*/

    /*DistrictServiceImpl districtService = new DistrictServiceImpl();
    DistrictModel districtModel = districtService.find(0);*/

    /*for (HospitalModel hospitalModel : districtService.getHospitalByDistrict(districtModel)){
      System.out.println(hospitalModel.getHospitalName());
    }*/

    /*HospitalServiceImpl hospitalService = new HospitalServiceImpl();
    HospitalModel hospitalModel = hospitalService.find(8);*/

    /*for (PoliclinicModel policlinicModel : hospitalService.getPoliclinicByHospital(hospitalModel)){
      System.out.println(policlinicModel.getPoliclinicName());
    }*/

    System.out.println(Encryptor.encryptPassword("123456"));
  }
}
