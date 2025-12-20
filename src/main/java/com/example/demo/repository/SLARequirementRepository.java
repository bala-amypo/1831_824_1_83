package com.example.demo.repository;

import com.example.demo.model.SLARequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlaRequirementRepository extends JpaRepository<SlaRequirement, Long> {
}
