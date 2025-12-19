package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(
    name = "sla_requirement",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "requirementName")
    }
)
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String requirementName;

    @Column(nullable = false)
    private String description;

    @NotNull
    @Positive
    private Integer maxDeliveryDays;

    @NotNull
    @Min(0)
    @Max(100)
    private Double minQualityScore;

    @Column(nullable = false)
    private Boolean active = true;

    // ---------- Constructors ----------
    public SLARequirement() {}

    public SLARequirement(
            String requirementName,
            String description,
            Integer maxDeliveryDays,
            Double minQualityScore,
            Boolean active) {

        this.requirementName = requirementName;
        this.description = description;
        this.maxDeliveryDays = maxDeliveryDays;
        this.minQualityScore = minQualityScore;
        this.active = (active != null) ? active : true;
    }

    // ---------- Getters ----------
    public Long getId() {
        return id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getMaxDeliveryDays() {
        return maxDeliveryDays;
    }

    public Double getMinQualityScore() {
        return minQualityScore;
    }

    public Boolean getActive() {
        return active;
    }

    // ---------- Setters ----------
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxDeliveryDays(Integer maxDeliveryDays) {
        this.maxDeliveryDays = maxDeliveryDays;
    }

    public void setMinQualityScore(Double minQualityScore) {
        this.minQualityScore = minQualityScore;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}