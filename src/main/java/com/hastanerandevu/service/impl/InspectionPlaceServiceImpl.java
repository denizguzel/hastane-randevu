package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.InspectionPlaceDaoImpl;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

/**
 * Created by Okan on 15.4.2017.
 */
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

  public List<AppointmentModel> getAllAppointmentsByInspectionPlace(InspectionPlaceModel inspectionPlaceModel) {
    return inspectionPlaceDao.getAllAppointmentsByInspectionPlace(inspectionPlaceModel);
  }
}
