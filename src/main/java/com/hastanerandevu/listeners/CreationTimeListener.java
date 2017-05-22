package com.hastanerandevu.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class CreationTimeListener {

  @PrePersist
  @PreUpdate
  public void setModifiedTime(final Updatable entity) {
    entity.setModifiedTime(new Date());
  }

}
