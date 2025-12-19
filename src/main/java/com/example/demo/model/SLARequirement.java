package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "slarequirement")
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requirementName;
    private String description;
    private Integer maxDeliveryDays;

    @Column(nullable = false)
    private Integer minQualityScore;

    private Boolean active;

    public SLARequirement() {}

    public SLARequirement(String requirementName, String description,
                          Integer maxDeliveryDays, Integer minQualityScore,
                          Boolean active) {
        this.requirementName = requirementName;
        this.description = description;
        this.maxDeliveryDays = maxDeliveryDays;
        this.minQualityScore = minQualityScore;
        this.active = active;
    }

    // GETTERS
    public Long getId() { return id; }

    public String getRequirementName() { return requirementName; }
    public String getDescription() { return description; }
    public Integer getMaxDeliveryDays() { return maxDeliveryDays; }
    public Integer getMinQualityScore() { return minQualityScore; }
    public Boolean getActive() { return active; }

    // SETTERS
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxDeliveryDays(Integer maxDeliveryDays) {
        this.maxDeliveryDays = maxDeliveryDays;
    }

    public void setMinQualityScore(Integer minQualityScore) {
        this.minQualityScore = minQualityScore;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
