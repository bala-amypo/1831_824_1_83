package com.example.demo.service.impl;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl
        implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository repo;

    public DeliveryEvaluationServiceImpl(DeliveryEvaluationRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation) {
        evaluation.setId(null); // force auto-increment
        return repo.save(evaluation);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("DeliveryEvaluation not found with id " + id));
    }

    @Override
    public List<DeliveryEvaluation> getAllEvaluations() {
        return repo.findAll();
    }

    @Override
    public DeliveryEvaluation updateEvaluation(Long id, DeliveryEvaluation evaluation) {
        DeliveryEvaluation existing = getEvaluationById(id);

        existing.setVendorId(evaluation.getVendorId());
        existing.setSlaRequirementId(evaluation.getSlaRequirementId());
        existing.setDeliveryDays(evaluation.getDeliveryDays());
        existing.setQualityScore(evaluation.getQualityScore());
        existing.setPassed(evaluation.getPassed());

        return repo.save(existing);
    }

    @Override
    public void deleteEvaluation(Long id) {
        repo.deleteById(id);
    }
}
