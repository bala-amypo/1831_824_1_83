package com.yourpackage.vendortracker.service;

import com.yourpackage.vendortracker.dto.EvaluationRequest;
import com.yourpackage.vendortracker.model.DeliveryEvaluation;
import com.yourpackage.vendortracker.model.SlaRequirement;
import com.yourpackage.vendortracker.model.Vendor;
import com.yourpackage.vendortracker.repository.DeliveryEvaluationRepository;
import com.yourpackage.vendortracker.repository.SlaRequirementRepository;
import com.yourpackage.vendortracker.repository.VendorRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evaluationRepository;
    private final VendorRepository vendorRepository;
    private final SlaRequirementRepository slaRequirementRepository;

    public DeliveryEvaluationService(
            DeliveryEvaluationRepository evaluationRepository,
            VendorRepository vendorRepository,
            SlaRequirementRepository slaRequirementRepository) {

        this.evaluationRepository = evaluationRepository;
        this.vendorRepository = vendorRepository;
        this.slaRequirementRepository = slaRequirementRepository;
    }

    @Transactional
    public DeliveryEvaluation createEvaluation(EvaluationRequest dto) {

        Vendor vendor = vendorRepository.findById(dto.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        SlaRequirement sla = slaRequirementRepository.findById(dto.getSlaRequirementId())
                .orElseThrow(() -> new RuntimeException("SLA Requirement not found"));

        DeliveryEvaluation eval = new DeliveryEvaluation();
        eval.setVendor(vendor);
        eval.setSlaRequirement(sla);
        eval.setActualDeliveryDays(dto.getActualDeliveryDays());
        eval.setQualityScore(dto.getQualityScore());
        eval.setEvaluationDate(LocalDate.now());

        eval.setMeetsDeliveryTarget(
                dto.getActualDeliveryDays() <= sla.getMaxDeliveryDays()
        );

        eval.setMeetsQualityTarget(
                dto.getQualityScore() >= sla.getMinQualityScore()
        );

        return evaluationRepository.save(eval);
    }
}
