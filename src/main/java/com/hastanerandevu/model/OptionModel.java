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
@Table(name = "T_OPTION")
public class OptionModel implements Creatable, Updatable {

  @Id
  @Column(name = "PK")
  @GeneratedValue(generator = "option_pk")
  @SequenceGenerator(name = "option_pk", sequenceName = "SEQ_OPTION_PK", allocationSize = 1)
  private long pk;

  @Column(name = "OPTION_TEXT")
  private String optionText;

  @Column(name = "COUNT", insertable = false)
  private int count;

  @Column(name = "CREATION_TIME")
  private Date creationTime;

  @Column(name = "MODIFIED_TIME")
  private Date modifiedTime;

  @Column(name = "IS_ACTIVE", insertable = false)
  private char isActive;

  @Column(name = "SORT_ORDER_NO")
  private int sortOrderNo = 999;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_SURVEY")
  private SurveyModel survey;

  public long getPk() {
    return pk;
  }

  public void setPk(long pk) {
    this.pk = pk;
  }

  public String getOptionText() {
    return optionText;
  }

  public void setOptionText(String optionText) {
    this.optionText = optionText;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public char getIsActive() {
    return isActive;
  }

  public void setIsActive(char isActive) {
    this.isActive = isActive;
  }

  public int getSortOrderNo() {
    return sortOrderNo;
  }

  public void setSortOrderNo(int sortOrderNo) {
    this.sortOrderNo = sortOrderNo;
  }

  public SurveyModel getSurvey() {
    return survey;
  }

  public void setSurvey(SurveyModel survey) {
    this.survey = survey;
  }
}
