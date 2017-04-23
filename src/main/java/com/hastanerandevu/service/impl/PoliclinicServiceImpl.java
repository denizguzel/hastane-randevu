package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.PoliclinicDaoImpl;
import com.hastanerandevu.model.AppointmentModel;
import com.hastanerandevu.model.HospitalPoliclinicRelModel;
import com.hastanerandevu.model.InspectionPlaceModel;
import com.hastanerandevu.model.PoliclinicModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class PoliclinicServiceImpl implements BaseService<PoliclinicModel> {
  private PoliclinicDaoImpl policlinicDao = new PoliclinicDaoImpl();

  @Override
  public void create(PoliclinicModel model) {
    policlinicDao.create(model);
  }

  @Override
  public void update(PoliclinicModel model) {
    policlinicDao.update(model);
  }

  @Override
  public void delete(PoliclinicModel model) {
    policlinicDao.delete(model);
  }

  @Override
  public PoliclinicModel find(long id) {
    return policlinicDao.find(id);
  }

  @Override
  public List<PoliclinicModel> findAll() {
    return policlinicDao.findAll();
  }

  public List<InspectionPlaceModel> getInspectionPlacesByHospitalPoliclinicRel(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    return policlinicDao.getInspectionPlacesByHospitalPoliclinicRel(hospitalPoliclinicRelModel);
  }

  public List<AppointmentModel> getAppointmentsByPoliclinic(HospitalPoliclinicRelModel hospitalPoliclinicRelModel) {
    return policlinicDao.getAppointmentsByPoliclinic(hospitalPoliclinicRelModel);
  }
}
