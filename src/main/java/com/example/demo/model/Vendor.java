package com.example.demo.model;
import jakarta.persistence.Id;
import java.security.Timestamp;
import jakarta.persistence.Column;

public class Vendor{
  @Id
  private Long id;
  @column(unique=true)
  private String name;
private String contactEmail;
private String contactPhone;
private boolean active;
private Timestamp createdAt;
private Timestamp updatedAt;

public Long getId(){
    return id;
}
public void setId(Long id){
    this.id=id;

public String getId(){
    return name;
}
public void setId(String name){
    this.name=name;
}

public String getId(){
    return contactEmail;
}
public void setId(String contactEmail){
    this.contactEmail=contactEmail;
}

public String getId(){
    return contactPhone;
}
public void setId(String contactPhone){
    this.contactPhone=contactPhone;
}

public boolean getId(){
    return active;
}
public void setId(boolean active){
    this.active=active;
}

public Timestamp getId(){
    return createdAt;
}
public void setId(Timestamp createdAt){
    this.createdAt=createdAt;
}

public Timestamp getId(){
    return updatedAt;
}
public void setId(Timestamp updatedAt){
    this.updated=updatedt;
}
}