package com.example.demo.controller;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.SlaRequirement;
import com.example.demo.model.Vendor;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.SlaRequirementRepository;
import com.example.demo.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/delivery-evaluations")
public class DeliveryEvaluationController {

    @Autowired
    private DeliveryEvaluationRepository deliveryEvaluationRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private SlaRequirementRepository slaRequirementRepository;

    // GET all delivery evaluations
    @GetMapping
    public List<DeliveryEvaluation> getAllEvaluations() {
        return deliveryEvaluationRepository.findAll();
    }

    // POST create delivery evaluation (FIXED)
    @PostMapping
    public ResponseEntity<DeliveryEvaluation> createEvaluation(
            @RequestParam Long vendorId,
            @RequestParam Long slaRequirementId,
            @RequestParam int actualDeliveryDays,
            @RequestParam double qualityScore) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vendor not found"));

        SlaRequirement slaRequirement = slaRequirementRepository.findById(slaRequirementId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "SLA Requirement not found"));

        DeliveryEvaluation evaluation = new DeliveryEvaluation();
        evaluation.setVendor(vendor);
        evaluation.setSlaRequirement(slaRequirement);
        evaluation.setActualDeliveryDays(actualDeliveryDays);
        evaluation.setQualityScore(qualityScore);
        evaluation.setEvaluationDate(LocalDate.now());

        evaluation.setMeetsDeliveryTarget(
                actualDeliveryDays <= slaRequirement.getMaxDeliveryDays());
        evaluation.setMeetsQualityTarget(
                qualityScore >= slaRequirement.getMinQualityScore());

        return ResponseEntity.ok(deliveryEvaluationRepository.save(evaluation));
    }
}
