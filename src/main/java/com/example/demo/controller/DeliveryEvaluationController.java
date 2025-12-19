package com.example.demo.controller;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-evaluations")
public class DeliveryEvaluationController {

    private final DeliveryEvaluationService deliveryEvaluationService;

    public DeliveryEvaluationController(DeliveryEvaluationService deliveryEvaluationService) {
        this.deliveryEvaluationService = deliveryEvaluationService;
    }

    @PostMapping
    public DeliveryEvaluation createEvaluation(
            @RequestParam Long vendorId,
            @RequestParam Long slaRequirementId,
            @RequestParam Integer actualDeliveryDays,
            @RequestParam Double qualityScore) {

        return deliveryEvaluationService.createEvaluation(
                vendorId,
                slaRequirementId,
                actualDeliveryDays,
                qualityScore
        );
    }

    @GetMapping
    public List<DeliveryEvaluation> getAllEvaluations() {
        return deliveryEvaluationService.getAllEvaluations();
    }

    @GetMapping("/{id}")
    public DeliveryEvaluation getEvaluationById(@PathVariable Long id) {
        return deliveryEvaluationService.getEvaluationById(id);
    }
}
