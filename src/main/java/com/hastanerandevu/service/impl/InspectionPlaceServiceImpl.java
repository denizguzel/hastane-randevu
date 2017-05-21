package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.InspectionPlaceDaoImpl;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.service.BaseService;

import java.util.Date;
import java.util.List;

public class InspectionPlaceServiceImpl implements BaseService<InspectionPlaceModel> {

  private InspectionPlaceDaoImpl inspectionPlaceDao = new InspectionPlaceDaoImpl();

  @Override
  public void create(InspectionPlaceModel model) {
    inspectionPlaceDao.create(model);
  }

  @Override
  public void update(InspectionPlaceModel model) {
    inspectionPlaceDao.update(model);
  }

  @Override
  public void delete(InspectionPlaceModel model) {
    inspectionPlaceDao.delete(model);
  }

  @Override
  public InspectionPlaceModel find(long id) {
    return inspectionPlaceDao.find(id);
  }

  @Override
  public List<InspectionPlaceModel> findAll() {
    return inspectionPlaceDao.findAll();
  }

  public List<InspectionPlaceModel> getAppointments(InspectionPlaceModel inspectionPlaceModel) {
    return inspectionPlaceDao.getAppointments(inspectionPlaceModel);
  }

  public List<InspectionPlaceModel> getAppointmentHeaderByInspectionPlace(InspectionPlaceModel inspectionPlaceModel, Date startDate, Date endDate) {
    return inspectionPlaceDao.getAppointmentHeaderByInspectionPlace(inspectionPlaceModel, startDate, endDate);
  }

  public List<InspectionPlaceModel> getAppointmentHeaderByInspectionPlace(InspectionPlaceModel inspectionPlaceModel, Date startDate) {
    return inspectionPlaceDao.getAppointmentHeaderByInspectionPlace(inspectionPlaceModel, startDate);
  }

  public List<InspectionPlaceModel> getAppointmentHeaderByInspectionPlace(InspectionPlaceModel inspectionPlaceModel) {
    return inspectionPlaceDao.getAppointmentHeaderByInspectionPlace(inspectionPlaceModel);
  }

}
