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
 public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOnTimePercentage() {
        return onTimePercentage;
    }

    public void setOnTimePercentage(double onTimePercentage) {
        this.onTimePercentage = onTimePercentage;
    }

    public double getQualityCompliancePercentage() {
        return qualityCompliancePercentage;
    }

    public void setQualityCompliancePercentage(double qualityCompliancePercentage) {
        this.qualityCompliancePercentage = qualityCompliancePercentage;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(Timestamp calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
    public VendorPerformanceScore(Long id, double onTimePercentage, double qualityCompliancePercentage, double overallScore, Timestamp calculatedAt){
 this.id = id;
  this.onTimePercentage = onTimePercentage;
  this.qualityCompliancePercentage = qualityCompliancePercentage;
this.overallScore = overallScore;
this.calculatedAt = calculatedAt;
    }
    public VendorPerformanceScore(){}
}