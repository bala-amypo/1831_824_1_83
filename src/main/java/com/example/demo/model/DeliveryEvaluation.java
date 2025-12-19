package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonFormat;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;

@Entity
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "actualDeliveryDays must be >= 0")
    private int actualDeliveryDays;

    @DecimalMin(value = "0.0", message = "qualityScore must be >= 0")
    @DecimalMax(value = "1.0", message = "qualityScore must be <= 1")
    private double qualityScore;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate evaluationDate;

    private boolean meetsDeliveryTarget;

    private boolean meetsQualityTarget;

    // Default constructor
    public DeliveryEvaluation() {}

    // Full constructor
    public DeliveryEvaluation(Long id, int actualDeliveryDays, double qualityScore,
                              LocalDate evaluationDate, boolean meetsDeliveryTarget,
                              boolean meetsQualityTarget) {
        this.id = id;
        this.actualDeliveryDays = actualDeliveryDays;
        this.qualityScore = qualityScore;
        this.evaluationDate = evaluationDate;
        this.meetsDeliveryTarget = meetsDeliveryTarget;
        this.meetsQualityTarget = meetsQualityTarget;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getActualDeliveryDays() { return actualDeliveryDays; }
    public void setActualDeliveryDays(int actualDeliveryDays) { this.actualDeliveryDays = actualDeliveryDays; }

    public double getQualityScore() { return qualityScore; }
    public void setQualityScore(double qualityScore) { this.qualityScore = qualityScore; }

    public LocalDate getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(LocalDate evaluationDate) { this.evaluationDate = evaluationDate; }

    public boolean isMeetsDeliveryTarget() { return meetsDeliveryTarget; }
    public void setMeetsDeliveryTarget(boolean meetsDeliveryTarget) { this.meetsDeliveryTarget = meetsDeliveryTarget; }

    public boolean isMeetsQualityTarget() { return meetsQualityTarget; }
    public void setMeetsQualityTarget(boolean meetsQualityTarget) { this.meetsQualityTarget = meetsQualityTarget; }
}
