package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.service.DeliveryEvaluationService;

@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    @Autowired
    private DeliveryEvaluationRepository repo;

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation) {
        evaluation.setMeetsDeliveryTarget(true);
        evaluation.setMeetsQualityTarget(true);
        return repo.save(evaluation);
    }

    @Override
    public DeliveryEvaluation updateEvaluation(Long id, DeliveryEvaluation evaluation) {
        DeliveryEvaluation existing = getEvaluationById(id);
        existing.setActualDeliveryDays(evaluation.getActualDeliveryDays());
        existing.setQualityScore(evaluation.getQualityScore());
        existing.setEvaluationDate(evaluation.getEvaluationDate());
        existing.setMeetsDeliveryTarget(evaluation.isMeetsDeliveryTarget());
        existing.setMeetsQualityTarget(evaluation.isMeetsQualityTarget());
        return repo.save(existing);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("DeliveryEvaluation not found"));
    }

    @Override
    public List<DeliveryEvaluation> getAllEvaluations() {
        return repo.findAll();
    }

    @Override
    public void deactivateEvaluation(Long id) {
        DeliveryEvaluation existing = getEvaluationById(id);
        existing.setMeetsDeliveryTarget(false);
        existing.setMeetsQualityTarget(false);
        repo.save(existing);
    }
}
