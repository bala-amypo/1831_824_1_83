package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_evaluation")
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "sla_requirement_id", nullable = false)
    private SLARequirement slaRequirement;

    @Column(name = "actual_delivery_days", nullable = false)
    private Integer actualDeliveryDays;

    @Column(name = "quality_score", nullable = false)
    private Double qualityScore;

    @Column(name = "evaluation_date")
    private LocalDate evaluationDate = LocalDate.now();

    @Column(name = "meets_delivery_target")
    private Boolean meetsDeliveryTarget;

    @Column(name = "meets_quality_target")
    private Boolean meetsQualityTarget;

    public Long getId() { 
        return id; 
        }
    public void setId(Long id) {
     this.id = id;
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

    public LocalDate getEvaluationDate() {
     return evaluationDate; 
     }
    public void setEvaluationDate(LocalDate evaluationDate) {
         this.evaluationDate = evaluationDate;
          }

    public Boolean getMeetsDeliveryTarget() {
         return meetsDeliveryTarget; 
         }
    public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) { 
        this.meetsDeliveryTarget = meetsDeliveryTarget; 
        }

    public Boolean getMeetsQualityTarget() {
         return meetsQualityTarget; 
         }
    public void setMeetsQualityTarget(Boolean meetsQualityTarget) {
         this.meetsQualityTarget = meetsQualityTarget;
          }
           public DeliveryEvaluation(Integer actualDeliveryDays, Long id, Boolean meetsDeliveryTarget, Boolean meetsQualityTarget, Double qualityScore, SLARequirement slaRequirement, Vendor vendor) {
        this.actualDeliveryDays = actualDeliveryDays;
        this.id = id;
        this.meetsDeliveryTarget = meetsDeliveryTarget;
        this.meetsQualityTarget = meetsQualityTarget;
        this.qualityScore = qualityScore;
        this.slaRequirement = slaRequirement;
        this.vendor = vendor;
    }
    DeliveryEvaluation()   
}
