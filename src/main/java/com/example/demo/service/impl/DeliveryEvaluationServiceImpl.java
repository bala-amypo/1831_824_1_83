package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryEvaluationService;

import java.util.Date;
import java.util.List;

public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evaluationRepository;
    private final VendorRepository vendorRepository;
    private final SLARequirementRepository slaRequirementRepository;

    // 🚨 EXACT constructor order required by test suite
    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository evaluationRepository,
            VendorRepository vendorRepository,
            SLARequirementRepository slaRequirementRepository
    ) {
        this.evaluationRepository = evaluationRepository;
        this.vendorRepository = vendorRepository;
        this.slaRequirementRepository = slaRequirementRepository;
    }

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation) {

        Vendor vendor = vendorRepository.findById(
                evaluation.getVendor().getId()
        ).orElseThrow(() -> new IllegalArgumentException("not found"));

        if (!vendor.getActive()) {
            throw new IllegalStateException("active vendors");
        }

        SLARequirement sla = slaRequirementRepository.findById(
                evaluation.getSlaRequirement().getId()
        ).orElseThrow(() -> new IllegalArgumentException("not found"));

        if (evaluation.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException("Max delivery days");
        }

        if (evaluation.getQualityScore() < 0 || evaluation.getQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score between 0 and 100");
        }

        boolean meetsDelivery =
                evaluation.getActualDeliveryDays() <= sla.getMaxDeliveryDays();

        boolean meetsQuality =
                evaluation.getQualityScore() >= sla.getMinQualityScore();

        evaluation.setVendor(vendor);
        evaluation.setSlaRequirement(sla);
        evaluation.setEvaluationDate(new Date());

        // ✅ FIXED: using setters
        evaluation.setMeetsDeliveryTarget(meetsDelivery);
        evaluation.setMeetsQualityTarget(meetsQuality);

        return evaluationRepository.save(evaluation);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
        return evaluationRepository.findByVendorId(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementId) {
        return evaluationRepository.findBySlaRequirementId(requirementId);
    }
}
