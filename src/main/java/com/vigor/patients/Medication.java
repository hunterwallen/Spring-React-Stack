package com.vigor.patients;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medication {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String dosage;

  private Integer frequencyInt;

  private String frequencyUnit;

  private Integer refillsLeft;

  private String refillDate;

  private Integer refillFrequencyInt;

  private String refillFrequencyUnit;

  private String patientId;


  //set id

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  //set name

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  //set dosage

  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }



  //set frequencyInt

  public Integer getFrequencyInt() {
    return frequencyInt;
  }

  public void setFrequencyInt(Integer frequencyInt) {
    this.frequencyInt = frequencyInt;
  }


  //set frequencyUnit

  public String getFrequencyUnit() {
    return frequencyUnit;
  }

  public void setFrequencyUnit(String frequencyUnit) {
    this.frequencyUnit = frequencyUnit;
  }


  //set refillsLeft

  public Integer getRefillsLeft() {
    return refillsLeft;
  }

  public void setRefillsLeft(Integer refillsLeft) {
    this.refillsLeft = refillsLeft;
  }


  //set refillDate

  public String getRefillDate() {
    return refillDate;
  }

  public void setRefillDate(String refillDate) {
    this.refillDate = refillDate;
  }


  //set refillFrequencyInt

  public Integer getRefillFrequencyInt() {
    return refillFrequencyInt;
  }

  public void setRefillFrequencyInt(Integer refillFrequencyInt) {
    this.refillFrequencyInt = refillFrequencyInt;
  }


  //set refillFrequencyUnit

  public String getRefillFrequencyUnit() {
    return refillFrequencyUnit;
  }

  public void setRefillFrequencyUnit(String refillFrequencyUnit) {
    this.refillFrequencyUnit = refillFrequencyUnit;
  }


  //set patientId

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

}
