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

}