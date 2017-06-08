package com.hastanerandevu.model;

import com.hastanerandevu.listeners.Creatable;
import com.hastanerandevu.listeners.CreationTimeListener;
import com.hastanerandevu.listeners.ModifiedTimeListener;
import com.hastanerandevu.listeners.Updatable;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners({
  CreationTimeListener.class,
  ModifiedTimeListener.class
})
@Table(name = "T_ADMIN")
public class AdminModel implements Creatable, Updatable {
  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "admin_pk")
  @SequenceGenerator(name = "admin_pk", sequenceName = "SEQ_ADMIN_PK", allocationSize = 1)
  private long pk;

  @Column(name = "U_ID")
  private String userId;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  public long getPk() {
    return pk;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  @Override
  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  @Override
  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public String getPassword() {
    return password;
  }
}
