package com.hastanerandevu.controller;

import com.hastanerandevu.model.Doctor;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path ("/doctors")
public class ControllerDoctor {

  @GET
  @Path ("/get")
  @Produces ("application/json")
  public Doctor getDoctorInJson () {
    Doctor doctor = new Doctor();
    doctor.setName("deniz");
    doctor.setSurname("güzel");
    return doctor;
  }

  @POST
  @Path ("/post")
  @Consumes ("application/json")
  public Response createDoctorInJson (Doctor doctor) {
    String result = "Doktor oluşturuldu: " + doctor;
    return Response.status(200).entity(result).build();
  }
}