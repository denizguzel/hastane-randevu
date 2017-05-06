package com.hastanerandevu.service.impl;

import com.hastanerandevu.constants.ProjectConstants;
import com.hastanerandevu.dao.impl.AppointmentDaoImpl;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.BaseService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentServiceImpl implements BaseService<AppointmentModel> {

  private AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();

  @Override
  public void create(AppointmentModel model) {
    appointmentDao.create(model);
  }

  @Override
  public void update(AppointmentModel model) {
    appointmentDao.update(model);
  }

  @Override
  public void delete(AppointmentModel model) {
    appointmentDao.delete(model);
  }

  @Override
  public AppointmentModel find(long id) {
    return appointmentDao.find(id);
  }

  @Override
  public List<AppointmentModel> findAll() {
    return appointmentDao.findAll();
  }

  public void holdAppointmentForPatient(AppointmentModel appointmentModel, PatientModel patientModel) {

    Calendar date = Calendar.getInstance();
    long t = date.getTimeInMillis();

    appointmentModel.setPatient(patientModel);
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.SUSPENDED);
    appointmentModel.setExpirationTimeForSuspend(new Date(t + (5 * ProjectConstants.ONE_MINUTE_IN_MILLIS)));
    this.update(appointmentModel);
  }

  public void confirmAppointment(AppointmentModel appointmentModel, PatientModel patientModel) {
    appointmentModel.setPatient(patientModel);
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.RESERVED);
    appointmentModel.setExpirationTimeForSuspend(null);
    appointmentModel.setMessageToDoctor(appointmentModel.getMessageToDoctor());
    this.update(appointmentModel);
  }

  public void clearAppointment(AppointmentModel appointmentModel) {
    appointmentModel.setPatient(null);
    appointmentModel.setMessageToDoctor(null);
    appointmentModel.setExpirationTimeForSuspend(null);
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.NOT_RESERVED);
    this.update(appointmentModel);
  }

  public List<AppointmentModel> getAllAppointmentsByInspectionPlace(InspectionPlaceModel inspectionPlaceModel) {
    return appointmentDao.getAllAppointmentsByInspectionPlace(inspectionPlaceModel);
  }

  public List<AppointmentModel> getAllCompletableAppointments() {
    return appointmentDao.getAllCompletableAppointments();
  }

  public List<AppointmentModel> getAllSuspendedAppointments() {
    return appointmentDao.getAllSuspendedAppointments();
  }
}
