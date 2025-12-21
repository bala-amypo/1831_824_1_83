package com.yourpackage.vendortracker.controller;

import com.yourpackage.vendortracker.dto.EvaluationRequest;
import com.yourpackage.vendortracker.model.DeliveryEvaluation;
import com.yourpackage.vendortracker.service.DeliveryEvaluationService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
public class DeliveryEvaluationController {

    private final DeliveryEvaluationService service;

    public DeliveryEvaluationController(DeliveryEvaluationService service) {
        this.service = service;
    }

    @Operation(summary = "Create delivery evaluation")
    @PostMapping
    public ResponseEntity<DeliveryEvaluation> createEvaluation(
            @RequestBody EvaluationRequest request) {

        return ResponseEntity.ok(service.createEvaluation(request));
    }
}
