package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class DeliveryEvaluation{
    @Id
    private Long id;
    private int actualDeliveryDays;
    private double qualityScore
}