package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.AppointmentDaoImpl;
import com.hastanerandevu.enums.AppointmentStatusEnum;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

/**
 * Created by Okan on 16.4.2017.
 */
public class AppointmentServiceImpl implements BaseService<AppointmentModel> {

  AppointmentDaoImpl appointmentDao = new AppointmentDaoImpl();

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

  public void holdAppointmentForPatient(AppointmentModel appointmentModel,PatientModel patientModel){
    appointmentModel.setPatient(patientModel);
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.SUSPENDED);
    this.update(appointmentModel);
  }

  public void confirmAppointment(AppointmentModel appointmentModel,PatientModel patientModel,String noteToDoctor){
    appointmentModel.setPatient(patientModel);
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.RESERVED);
    appointmentModel.setMessageToDoctor(noteToDoctor);
    this.update(appointmentModel);
  }

  public void completeAppointment(AppointmentModel appointmentModel){
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.COMPLETED);
    this.update(appointmentModel);
  }

  public void clearAppointment(AppointmentModel appointmentModel){
    appointmentModel.setPatient(null);
    appointmentModel.setMessageToDoctor(null);
    appointmentModel.setAppointmentStatus(AppointmentStatusEnum.NOT_RESERVED);
    this.update(appointmentModel);
  }
}
