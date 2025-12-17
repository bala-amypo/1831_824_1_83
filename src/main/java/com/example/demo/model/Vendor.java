package com.example.demo.model;
import jakarta.persistence.Id;
public class Vendor{
  @Id
  private Long id;
  @column(unique=true)
  private String name;
private String contactEmail;
private String contactPhone;
private boolean active;

}