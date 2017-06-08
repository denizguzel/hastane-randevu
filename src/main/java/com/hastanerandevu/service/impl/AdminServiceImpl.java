package com.hastanerandevu.service.impl;

import com.hastanerandevu.dao.impl.AdminDaoImpl;
import com.hastanerandevu.model.AdminModel;
import com.hastanerandevu.service.BaseService;

import java.util.List;

public class AdminServiceImpl implements BaseService<AdminModel> {

  private AdminDaoImpl adminDao = new AdminDaoImpl();

  @Override
  public void create(AdminModel model) {
    adminDao.create(model);
  }

  @Override
  public void update(AdminModel model) {
    adminDao.update(model);
  }

  @Override
  public void delete(AdminModel model) {
    adminDao.delete(model);
  }

  @Override
  public AdminModel find(long id) {
    return adminDao.find(id);
  }

  @Override
  public List<AdminModel> findAll() {
    return adminDao.findAll();
  }

  public AdminModel loginAdmin(AdminModel adminModel){
    return adminDao.loginAdmin(adminModel);
  }
}
