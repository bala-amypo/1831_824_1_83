package com.example.demo.model;
import jakarta.persistence.Id;
public class Vendor{
    @Id
    private Long id;
@column(unique=true)
private String requirementName;
private String description;
private int maxDeliveryDays;
private double minQualityScore;
private boolean active;

public Long getId(){
    return id;
}
public 
}