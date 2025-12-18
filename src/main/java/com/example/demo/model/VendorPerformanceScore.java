package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.security.Timestamp;
import jakarta.validation.constraints.Size;
@Entity
public class VendorPerformanceScore{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private double onTimePercentage;
private double qualityCompliancePercentage;
@Size(min=0,max=100)
private double overallScore;
private Timestamp calculatedAt;
}