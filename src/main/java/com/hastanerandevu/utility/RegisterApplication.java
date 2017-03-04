package com.hastanerandevu.utility;

import com.hastanerandevu.controller.ControllerDoctor;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RegisterApplication extends Application {

  private Set<Object> singletons = new HashSet<Object>();

  public RegisterApplication () {
    singletons.add(new ControllerDoctor());
  }

  @Override
  public Set<Object> getSingletons () {
    return singletons;
  }
}