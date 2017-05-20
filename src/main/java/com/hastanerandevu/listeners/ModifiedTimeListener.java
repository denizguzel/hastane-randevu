package com.hastanerandevu.listeners;

import javax.persistence.PrePersist;
import java.util.Date;

public class ModifiedTimeListener {

  @PrePersist
  public void setCreationTime(final Creatable entity) {
    entity.setCreationTime(new Date());
  }

}
