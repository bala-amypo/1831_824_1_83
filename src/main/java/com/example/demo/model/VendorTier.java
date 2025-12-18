package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
@Entity
public class VendorTier{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
     @Column(unique=true)
     private String tierName;
     private double minScoreThreshold;
     private string description;
     private boolean active = true;
     
}