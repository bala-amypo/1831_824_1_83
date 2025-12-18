package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
@Entity
public class DeliveryEvaluation{
    @Id
    private Long id;
    private int actualDeliveryDays;
    private double qualityScore;
    private Date evaluationDate;
    private boolean meetsDeliveryTarget;
    private boolean meetsQualityTarget;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getActualDeliveryDays() {
        return actualDeliveryDays;
    }

    public void setActualDeliveryDays(int actualDeliveryDays) {
        this.actualDeliveryDays = actualDeliveryDays;
    }

    public double getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public boolean isMeetsDeliveryTarget() {
        return meetsDeliveryTarget;
    }

    public void setMeetsDeliveryTarget(boolean meetsDeliveryTarget) {
        this.meetsDeliveryTarget = meetsDeliveryTarget;
    }

    public boolean isMeetsQualityTarget() {
        return meetsQualityTarget;
    }

    public void setMeetsQualityTarget(boolean meetsQualityTarget) {
        this.meetsQualityTarget = meetsQualityTarget;
    }
    public DeliveryEvaluation()
}
