package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryEvaluationService;
import java.util.Date;
import java.util.List;

public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evalRepo;
    private final VendorRepository vendorRepo;
    private final SLARequirementRepository slaRepo;

    // 🚨 EXACT constructor order required
    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository evalRepo,
            VendorRepository vendorRepo,
            SLARequirementRepository slaRepo
    ) {
        this.evalRepo = evalRepo;
        this.vendorRepo = vendorRepo;
        this.slaRepo = slaRepo;
    }

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation) {

        Vendor vendor = vendorRepo.findById(evaluation.getVendor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        if (!vendor.getActive()) {
            throw new IllegalStateException("active vendors");
        }

        SLARequirement sla = slaRepo.findById(evaluation.getSlaRequirement().getId())
                .orElseThrow(() -> new IllegalArgumentException("SLA not found"));

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

        evaluation.setEvaluationDate(new Date());
        evaluation.setVendor(vendor);
        evaluation.setSlaRequirement(sla);

        evaluation.meetsDeliveryTarget = meetsDelivery;
        evaluation.meetsQualityTarget = meetsQuality;

        return evalRepo.save(evaluation);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return evalRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
        return evalRepo.findByVendorId(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementId) {
        return evalRepo.findBySlaRequirementId(requirementId);
    }
}
