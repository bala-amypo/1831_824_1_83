package com.example.demo.service;

import com.example.demo.entity.DeliveryEvaluation;

import java.util.List;

public interface DeliveryEvaluationService {

    DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation);

    DeliveryEvaluation getEvaluationById(Long id);

    List<DeliveryEvaluation> getAllEvaluations();

    DeliveryEvaluation updateEvaluation(Long id, DeliveryEvaluation evaluation);

    void deleteEvaluation(Long id);
}
