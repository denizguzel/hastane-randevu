package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.ReviewsAboutDoctorsDaoImpl;
import com.hastanerandevu.model.DoctorModel;
import com.hastanerandevu.model.PatientModel;
import com.hastanerandevu.model.ReviewsAboutDoctorsModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class ReviewsAboutDoctorsServiceImpl implements BaseService<ReviewsAboutDoctorsModel> {

  private ReviewsAboutDoctorsDaoImpl reviewsAboutDoctorsDao = new ReviewsAboutDoctorsDaoImpl();

  @Override
  public void create(ReviewsAboutDoctorsModel model) {
    reviewsAboutDoctorsDao.create(model);
  }

  @Override
  public void update(ReviewsAboutDoctorsModel model) {
    reviewsAboutDoctorsDao.update(model);
  }

  @Override
  public void delete(ReviewsAboutDoctorsModel model) {
    reviewsAboutDoctorsDao.delete(model);
  }

  @Override
  public ReviewsAboutDoctorsModel find(long id) {
    return reviewsAboutDoctorsDao.find(id);
  }

  @Override
  public List<ReviewsAboutDoctorsModel> findAll() {
    return reviewsAboutDoctorsDao.findAll();
  }

  public List<ReviewsAboutDoctorsModel> getReviewsAboutDoctor(DoctorModel doctorModel) {
    return reviewsAboutDoctorsDao.getReviewsAboutDoctor(doctorModel);
  }

  public List<ReviewsAboutDoctorsModel> getReviewsOfPatient(PatientModel patientModel) {
    return reviewsAboutDoctorsDao.getReviewsOfPatient(patientModel);
  }

  public boolean patientHaveReviewAboutDoctor(PatientModel patientModel, DoctorModel doctorModel) {
    return reviewsAboutDoctorsDao.patientHaveReviewAboutDoctor(patientModel, doctorModel);
  }
}
