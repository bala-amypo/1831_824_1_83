package com.example.demo.model;
import jakarta.persistence.Id;
import java.security.Timestamp;
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

public 
}