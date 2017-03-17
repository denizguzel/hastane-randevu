package com.hastanerandevu.controller;

import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.PatientServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// TODO json işlemleri için
@Path ("/patient")
public class RestPatient {

  @GET
  @Path ("/{id}")
  @Produces ("application/json;charset=utf-8")
  public PatientModel getPatientById (@PathParam ("id") long id) {
    PatientServiceImpl patientService = new PatientServiceImpl();
    return patientService.find(id);
  }
}
