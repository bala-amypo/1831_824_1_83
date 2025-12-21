package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_tier")
public class VendorTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tier_name", unique = true, nullable = false)
    private String tierName;

    @Column(name = "min_score_threshold", nullable = false)
    private Double minScoreThreshold;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public Double getMinScoreThreshold() {
        return minScoreThreshold;
    }

    public void setMinScoreThreshold(Double minScoreThreshold) {
        this.minScoreThreshold = minScoreThreshold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
        public VendorTier(Long id, String tierName, Double minScoreThreshold, String description, Boolean active) {
        this.id = id;
        this.tierName = tierName;
        this.minScoreThreshold = minScoreThreshold;
        this.description = description;
        this.active = active;
    }
     public VendorTier() {}
}
