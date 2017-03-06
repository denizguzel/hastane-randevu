package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.AppointmentStatusDao;
import com.hastanerandevu.dao.impl.AppointmentStatusDaoImpl;
import com.hastanerandevu.model.AppointmentStatusModel;
import com.hastanerandevu.service.AppointmentStatusService;

import java.util.List;

public class AppointmentStatusServiceImpl implements AppointmentStatusService {
  private AppointmentStatusDao appointmentStatusDao = new AppointmentStatusDaoImpl();

  @Override
  public void createAppointmentStatus (String statusCode) {
    appointmentStatusDao.createAppointmentStatus(statusCode);
  }

  @Override
  public void updateAppointmentStatus (long id, String statusCode) {
    appointmentStatusDao.updateAppointmentStatus(id, statusCode);
  }

  @Override
  public void deleteAppointmentStatus (long id) {
    appointmentStatusDao.deleteAppointmentStatus(id);
  }

  @Override
  public AppointmentStatusModel findAppointmentStatus (long id) {
    return appointmentStatusDao.findAppointmentStatus(id);
  }

  @Override
  public List<AppointmentStatusModel> getAllAppointmentStatuses () {
    return appointmentStatusDao.getAllAppointmentStatuses();
  }
}
