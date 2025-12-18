package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DeliveryEvaluation;

@Repository
public interface DeliveryEvaluationRepository extends JpaRepository<DeliveryEvaluation, Long> {
    // Optional: check if an evaluation exists by some field
    boolean existsByEvaluationDate(LocalDate evaluationDate);
}
