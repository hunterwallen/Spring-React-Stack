package com.vigor.patients;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

  private String password;


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


  //set email

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  //set password
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
