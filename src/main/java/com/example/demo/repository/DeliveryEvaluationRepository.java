package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DeliveryEvaluation;

import java.time.LocalDate; // <-- Add this import

@Repository
public interface DeliveryEvaluationRepository extends JpaRepository<DeliveryEvaluation, Long> {
    boolean existsByEvaluationDate(LocalDate evaluationDate);
}
