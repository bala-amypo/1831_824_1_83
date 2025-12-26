package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    private Date evaluationDate;

    // getters & setters

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public SLARequirement getSlaRequirement() {
        return slaRequirement;
    }

    public void setSlaRequirement(SLARequirement slaRequirement) {
        this.slaRequirement = slaRequirement;
    }

    public Integer getActualDeliveryDays() {
        return actualDeliveryDays;
    }

    public void setActualDeliveryDays(Integer actualDeliveryDays) {
        this.actualDeliveryDays = actualDeliveryDays;
    }

    public Double getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(Double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public Boolean getMeetsDeliveryTarget() {
        return meetsDeliveryTarget;
    }

    public Boolean getMeetsQualityTarget() {
        return meetsQualityTarget;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
