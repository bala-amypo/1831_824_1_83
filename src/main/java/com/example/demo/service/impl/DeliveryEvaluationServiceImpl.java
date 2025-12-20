package com.example.demo.service.impl;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.SLARequirement;
import com.example.demo.model.Vendor;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    @Autowired
    private DeliveryEvaluationRepository evaluationRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private SLARequirementRepository slaRequirementRepository;

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation) {
        Vendor vendor = vendorRepository.findById(evaluation.getVendor().getId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        if (!vendor.getActive()) {
            throw new RuntimeException("Vendor is not active");
        }

        SLARequirement sla = slaRequirementRepository.findById(evaluation.getSlaRequirement().getId())
                .orElseThrow(() -> new RuntimeException("SLA Requirement not found"));

        if (evaluation.getActualDeliveryDays() < 0) {
            throw new RuntimeException("actualDeliveryDays must be >= 0");
        }

        if (evaluation.getQualityScore() < 0 || evaluation.getQualityScore() > 100) {
            throw new RuntimeException("qualityScore must be between 0 and 100");
        }

        evaluation.setMeetsDeliveryTarget(evaluation.getActualDeliveryDays() <= sla.getMaxDeliveryDays());
        evaluation.setMeetsQualityTarget(evaluation.getQualityScore() >= sla.getMinQualityScore());

        return evaluationRepository.save(evaluation);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
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
