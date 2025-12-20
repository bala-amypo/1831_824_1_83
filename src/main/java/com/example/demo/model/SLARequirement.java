package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "slarequirement")
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requirement_name", nullable = false)
    private String requirementName;

    private String description;

    @Column(name = "max_delivery_days", nullable = false)
    private int maxDeliveryDays;

    @Column(name = "min_quality_score", nullable = false)
    private double minQualityScore;

    private boolean active;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxDeliveryDays() {
        return maxDeliveryDays;
    }

    public void setMaxDeliveryDays(int maxDeliveryDays) {
        this.maxDeliveryDays = maxDeliveryDays;
    }

    public double getMinQualityScore() {
        return minQualityScore;
    }

    public void setMinQualityScore(double minQualityScore) {
        this.minQualityScore = minQualityScore;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
