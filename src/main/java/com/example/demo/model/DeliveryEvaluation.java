// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.util.Date;

// @Entity
// public class DeliveryEvaluation {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Vendor vendor;

//     @ManyToOne
//     private SLARequirement slaRequirement;

//     private Integer actualDeliveryDays;
//     private Double qualityScore;

//     private Boolean meetsDeliveryTarget;
//     private Boolean meetsQualityTarget;

//     @Temporal(TemporalType.DATE)
//     private Date evaluationDate;

//     // ===== Getters =====

//     public Long getId() {
//         return id;
//     }

//     public Vendor getVendor() {
//         return vendor;
//     }

//     public SLARequirement getSlaRequirement() {
//         return slaRequirement;
//     }

//     public Integer getActualDeliveryDays() {
//         return actualDeliveryDays;
//     }

//     public Double getQualityScore() {
//         return qualityScore;
//     }

//     public Boolean getMeetsDeliveryTarget() {
//         return meetsDeliveryTarget;
//     }

//     public Boolean getMeetsQualityTarget() {
//         return meetsQualityTarget;
//     }

//     public Date getEvaluationDate() {
//         return evaluationDate;
//     }

//     // ===== Setters =====

//     public void setVendor(Vendor vendor) {
//         this.vendor = vendor;
//     }

//     public void setSlaRequirement(SLARequirement slaRequirement) {
//         this.slaRequirement = slaRequirement;
//     }

//     public void setActualDeliveryDays(Integer actualDeliveryDays) {
//         this.actualDeliveryDays = actualDeliveryDays;
//     }

//     public void setQualityScore(Double qualityScore) {
//         this.qualityScore = qualityScore;
//     }

//     public void setEvaluationDate(Date evaluationDate) {
//         this.evaluationDate = evaluationDate;
//     }

//     public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) {
//         this.meetsDeliveryTarget = meetsDeliveryTarget;
//     }

//     public void setMeetsQualityTarget(Boolean meetsQualityTarget) {
//         this.meetsQualityTarget = meetsQualityTarget;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private SLARequirement slaRequirement;

    private Integer actualDeliveryDays;
    private Double qualityScore;
    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;
    private LocalDate evaluationDate;

    public DeliveryEvaluation() {}

    public DeliveryEvaluation(Vendor v, SLARequirement s, Integer days, Double score, LocalDate date) {
        this.vendor = v;
        this.slaRequirement = s;
        this.actualDeliveryDays = days;
        this.qualityScore = score;
        this.evaluationDate = date;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public SLARequirement getSlaRequirement() { return slaRequirement; }
    public void setSlaRequirement(SLARequirement slaRequirement) { this.slaRequirement = slaRequirement; }

    public Integer getActualDeliveryDays() { return actualDeliveryDays; }
    public void setActualDeliveryDays(Integer actualDeliveryDays) { this.actualDeliveryDays = actualDeliveryDays; }

    public Double getQualityScore() { return qualityScore; }
    public void setQualityScore(Double qualityScore) { this.qualityScore = qualityScore; }

    public Boolean getMeetsDeliveryTarget() { return meetsDeliveryTarget; }
    public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) { this.meetsDeliveryTarget = meetsDeliveryTarget; }

    public Boolean getMeetsQualityTarget() { return meetsQualityTarget; }
    public void setMeetsQualityTarget(Boolean meetsQualityTarget) { this.meetsQualityTarget = meetsQualityTarget; }

    public LocalDate getEvaluationDate() {   // ✅ REQUIRED
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
