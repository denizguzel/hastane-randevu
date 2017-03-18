package com.hastanerandevu.dao;

import java.util.List;

public interface BaseDao<T> {
  void create(T model);

  void update(long id, T model);

  void delete(long id);

  T find(long id);

  List<T> findAll();
}
