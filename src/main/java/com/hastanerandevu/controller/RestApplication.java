package com.hastanerandevu.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath ("/api")
public class RestApplication extends Application {

  private Set<Object> singletons = new HashSet<>();

  public RestApplication () {
    singletons.add(new RestPatient());
  }

  @Override
  public Set<Object> getSingletons () {
    return singletons;
  }
}
