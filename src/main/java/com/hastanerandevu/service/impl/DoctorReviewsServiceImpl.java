package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.DoctorReviewsDaoImpl;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.model.ReviewsAboutDoctorsModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

/**
 * Created by ouzun on 5/10/2017.
 */
public class DoctorReviewsServiceImpl implements BaseService<ReviewsAboutDoctorsModel> {

  DoctorReviewsDaoImpl doctorReviewsDao = new DoctorReviewsDaoImpl();

  @Override
  public void create(ReviewsAboutDoctorsModel model) {
    doctorReviewsDao.create(model);
  }

  @Override
  public void update(ReviewsAboutDoctorsModel model) {
    doctorReviewsDao.update(model);
  }

  @Override
  public void delete(ReviewsAboutDoctorsModel model) {
    doctorReviewsDao.delete(model);
  }

  @Override
  public ReviewsAboutDoctorsModel find(long id) {
    return doctorReviewsDao.find(id);
  }

  @Override
  public List<ReviewsAboutDoctorsModel> findAll() {
    return doctorReviewsDao.findAll();
  }

  public List<ReviewsAboutDoctorsModel> getReviewsAboutDoctor(DoctorModel doctorModel) {
    return doctorReviewsDao.getReviewsAboutDoctor(doctorModel);
  }

  public List<ReviewsAboutDoctorsModel> getReviewsOfPatient(PatientModel patientModel) {
    return doctorReviewsDao.getReviewsOfPatient(patientModel);
  }
}
