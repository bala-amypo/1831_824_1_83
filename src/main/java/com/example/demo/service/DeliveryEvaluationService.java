package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DeliveryEvaluation;

public interface DeliveryEvaluationService {

    DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation);

    DeliveryEvaluation updateEvaluation(Long id, DeliveryEvaluation evaluation);

    DeliveryEvaluation getEvaluationById(Long id);

    List<DeliveryEvaluation> getAllEvaluations();

    void deactivateEvaluation(Long id);
}
