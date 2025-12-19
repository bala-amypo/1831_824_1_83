package com.example.demo.repository;

import com.example.demo.entity.DeliveryEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryEvaluationRepository
        extends JpaRepository<DeliveryEvaluation, Long> {
}
