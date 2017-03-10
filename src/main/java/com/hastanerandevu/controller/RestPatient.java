package com.hastanerandevu.controller;

import com.hastanerandevu.dao.impl.PatientDaoImpl;
import com.hastanerandevu.model.PatientModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

// TODO json işlemleri için bu tarz bir şey kullanılacak diye düşünüyorum
@Path ("/doctors")
public class RestPatient {

  @GET
  @Path ("/get")
  @Produces ("application/json;charset=utf-8")
  public List<PatientModel> getPatient () {
    PatientDaoImpl patientDao = new PatientDaoImpl();
    return patientDao.findAll();
  }
}