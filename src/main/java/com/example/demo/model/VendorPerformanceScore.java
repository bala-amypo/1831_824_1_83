// package com.example.demo.model;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "vendor_performance_score")
// public class VendorPerformanceScore {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "vendor_id")
//     private Vendor vendor;

//     @Column(nullable = false)
//     private Double onTimePercentage;

//     @Column(nullable = false)
//     private Double qualityCompliancePercentage;

//     @Column(nullable = false)
//     private Double overallScore;

//     @Column(nullable = false)
//     private LocalDateTime calculatedAt;

    
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Vendor getVendor() {
//         return vendor;
//     }

//     public void setVendor(Vendor vendor) {
//         this.vendor = vendor;
//     }

//     public Double getOnTimePercentage() {
//         return onTimePercentage;
//     }

//     public void setOnTimePercentage(Double onTimePercentage) {
//         this.onTimePercentage = onTimePercentage;
//     }

//     public Double getQualityCompliancePercentage() {
//         return qualityCompliancePercentage;
//     }

//     public void setQualityCompliancePercentage(Double qualityCompliancePercentage) {
//         this.qualityCompliancePercentage = qualityCompliancePercentage;
//     }

//     public Double getOverallScore() {
//         return overallScore;
//     }

//     public void setOverallScore(Double overallScore) {
//         this.overallScore = overallScore;
//     }

//     public LocalDateTime getCalculatedAt() {
//         return calculatedAt;
//     }

//     public void setCalculatedAt(LocalDateTime calculatedAt) {
//         this.calculatedAt = calculatedAt;
//     }
//     public VendorPerformanceScore(Long id, Vendor vendor, Double onTimePercentage, Double qualityCompliancePercentage, Double overallScore, LocalDateTime calculatedAt) {
//         this.id = id;
//         this.vendor = vendor;
//         this.onTimePercentage = onTimePercentage;
//         this.qualityCompliancePercentage = qualityCompliancePercentage;
//         this.overallScore = overallScore;
//         this.calculatedAt = calculatedAt;
//     }
//       public VendorPerformanceScore() {}
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VendorPerformanceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private Double onTimePercentage;
    private Double qualityCompliancePercentage;
    private Double overallScore;

    private LocalDateTime calculatedAt = LocalDateTime.now();

    public VendorPerformanceScore() {}

    // ✅ used in many tests
    public VendorPerformanceScore(Vendor vendor,
                                  Double onTime,
                                  Double quality,
                                  Double overall) {
        this.vendor = vendor;
        this.onTimePercentage = onTime;
        this.qualityCompliancePercentage = quality;
        this.overallScore = overall;
    }

    // ✅ REQUIRED by test constructors
    public VendorPerformanceScore(Long id,
                                  Vendor vendor,
                                  Double onTime,
                                  Double quality,
                                  Double overall) {
        this.id = id;
        this.vendor = vendor;
        this.onTimePercentage = onTime;
        this.qualityCompliancePercentage = quality;
        this.overallScore = overall;
    }

    public Double getOnTimePercentage() { return onTimePercentage; }
    public Double getQualityCompliancePercentage() { return qualityCompliancePercentage; }
    public Double getOverallScore() { return overallScore; }
}
