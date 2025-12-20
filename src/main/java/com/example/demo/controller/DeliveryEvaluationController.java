package com.example.demo.controller;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class DeliveryEvaluationController {

    @Autowired
    private DeliveryEvaluationService evaluationService;

    @PostMapping
    public DeliveryEvaluation createEvaluation(@RequestBody DeliveryEvaluation evaluation) {
        return evaluationService.createEvaluation(evaluation);
    }

    @GetMapping("/{id}")
    public DeliveryEvaluation getEvaluationById(@PathVariable Long id) {
        return evaluationService.getEvaluationById(id);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<DeliveryEvaluation> getEvaluationsForVendor(@PathVariable Long vendorId) {
        return evaluationService.getEvaluationsForVendor(vendorId);
    }

    @GetMapping("/requirement/{requirementId}")
    public List<DeliveryEvaluation> getEvaluationsForRequirement(@PathVariable Long requirementId) {
        return evaluationService.getEvaluationsForRequirement(requirementId);
    }
}
