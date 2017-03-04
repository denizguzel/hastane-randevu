package com.hastanerandevu.controller;

import com.hastanerandevu.model.DoctorModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path ("/doctors")
public class ControllerDoctor {

  @GET
  @Path ("/get")
  @Produces ("application/json")
  public DoctorModel getDoctorInJson () {
    DoctorModel doctor = new DoctorModel();
    doctor.setFirstName("deniz");
    doctor.setLastName("güzel");
    return doctor;
  }

  @POST
  @Path ("/post")
  @Consumes ("application/json")
  public Response createDoctorInJson (DoctorModel doctor) {
    String result = "Doktor oluşturuldu: " + doctor;
    return Response.status(200).entity(result).build();
  }
}