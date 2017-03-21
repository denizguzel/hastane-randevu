package com.hastanerandevu.service;

import java.util.List;

public interface BaseService<T> {
  void create(T model);

  void update(T model);

  void delete(T model);

  T find(long id);

  List<T> findAll();
}
