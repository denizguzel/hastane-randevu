package com.hastanerandevu.controller;

import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.model.PatientModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

// TODO json işlemleri için bu tarz bir şey kullanılacak diye düşünüyorum
@Path ("/doctors")
public class ControllerDoctor {

  @GET
  @Path ("/get")
  @Produces ("application/json")
  public PatientModel getMethod () {
    PatientModel patientModel = new PatientModel();
    patientModel.setFirstName("deniz");
    patientModel.setLastName("güzel");

    return patientModel;
  }

  @POST
  @Path ("/post")
  @Consumes ("application/json")
  public Response postMethod (DoctorModel doctor) {
    String result = "Doktor oluşturuldu: " + doctor;
    return Response.status(200).entity(result).build();
  }
}