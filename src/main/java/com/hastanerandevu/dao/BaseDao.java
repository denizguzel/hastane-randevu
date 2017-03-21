package com.hastanerandevu.dao;

import java.util.List;

public interface BaseDao<T> {
  void create(T model);

  void update(T model);

  void delete(T model);

  T find(long id);

  List<T> findAll();
}
