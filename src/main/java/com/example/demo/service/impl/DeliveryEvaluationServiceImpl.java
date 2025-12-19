package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.entity.SLARequirement;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evaluationRepository;
    private final VendorRepository vendorRepository;
    private final SLARequirementRepository slaRequirementRepository;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository evaluationRepository,
            VendorRepository vendorRepository,
            SLARequirementRepository slaRequirementRepository) {
        this.evaluationRepository = evaluationRepository;
        this.vendorRepository = vendorRepository;
        this.slaRequirementRepository = slaRequirementRepository;
    }

    @Override
    public DeliveryEvaluation createEvaluation(
            Long vendorId,
            Long slaRequirementId,
            Integer actualDeliveryDays,
            Double qualityScore) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        SLARequirement sla = slaRequirementRepository.findById(slaRequirementId)
                .orElseThrow(() -> new RuntimeException("SLA Requirement not found"));

        boolean meetsDeliveryTarget =
                actualDeliveryDays <= sla.getMaxDeliveryDays();

        boolean meetsQualityTarget =
                qualityScore >= sla.getMinQualityScore();

        DeliveryEvaluation evaluation = new DeliveryEvaluation();
        evaluation.setVendor(vendor);
        evaluation.setSlaRequirement(sla);
        evaluation.setActualDeliveryDays(actualDeliveryDays);
        evaluation.setQualityScore(qualityScore);
        evaluation.setEvaluationDate(LocalDate.now());
        evaluation.setMeetsDeliveryTarget(meetsDeliveryTarget);
        evaluation.setMeetsQualityTarget(meetsQualityTarget);

        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<DeliveryEvaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Evaluation not found"));
    }
}
