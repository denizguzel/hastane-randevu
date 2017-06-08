package com.hastanerandevu.dao.impl;

import com.hastanerandevu.converter.Encryptor;
import com.hastanerandevu.model.AdminModel;

import javax.persistence.Query;

public class AdminDaoImpl extends BaseDaoImpl<AdminModel> {
  public AdminModel loginAdmin(AdminModel adminModel){
    Query query = getEntitymanager().createQuery("SELECT e FROM AdminModel e WHERE e.userId = :USER_ID AND e.password = :PASSWORD");
    query.setParameter("USER_ID",adminModel.getUserId());
    query.setParameter("PASSWORD", Encryptor.encrypt(adminModel.getPassword()));

    if(query.getResultList().size() > 0) {
      return (AdminModel) query.getResultList().get(0);
    } else {
      return null;
    }
  }
}
