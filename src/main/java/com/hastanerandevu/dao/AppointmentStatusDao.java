package com.hastanerandevu.dao;

import com.hastanerandevu.model.AppointmentStatusModel;

import java.util.List;

public interface AppointmentStatusDao {
  void createAppointmentStatus (String statusCode);

  void updateAppointmentStatus (long id, String statusCode);

  void deleteAppointmentStatus (long id);

  AppointmentStatusModel findAppointmentStatus (long id);

  List<AppointmentStatusModel> getAllAppointmentStatuses ();
}
