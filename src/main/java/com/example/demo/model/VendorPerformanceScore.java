package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendor_performance_score")
public class VendorPerformanceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @Column(nullable = false)
    private Double onTimePercentage;

    @Column(nullable = false)
    private Double qualityCompliancePercentage;

    @Column(nullable = false)
    private Double overallScore;

    @Column(nullable = false)
    private LocalDateTime calculatedAt;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public Double getOnTimePercentage() { return onTimePercentage; }
    public void setOnTimePercentage(Double onTimePercentage) { this.onTimePercentage = onTimePercentage; }

    public Double getQualityCompliancePercentage() { return qualityCompliancePercentage; }
    public void setQualityCompliancePercentage(Double qualityCompliancePercentage) {
        this.qualityCompliancePercentage = qualityCompliancePercentage;
    }

    public Double getOverallScore() { return overallScore; }
    public void setOverallScore(Double overallScore) { this.overallScore = overallScore; }

    public LocalDateTime getCalculatedAt() { return calculatedAt; }
    public void setCalculatedAt(LocalDateTime calculatedAt) { this.calculatedAt = calculatedAt; }
}
