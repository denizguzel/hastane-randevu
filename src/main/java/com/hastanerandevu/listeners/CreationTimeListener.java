package com.hastanerandevu.listeners;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CreationTimeListener {

  @PrePersist
  @PreUpdate
  public void setModifiedTime(final Updatable entity) {
    entity.setModifiedTime(new Date());
  }

}
