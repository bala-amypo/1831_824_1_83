package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SlaRequirementRepository;
import com.example.demo.service.SlaRequirementService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlaRequirementServiceImpl implements SlaRequirementService {

    private final SlaRequirementRepository repository;

    public SlaRequirementServiceImpl(SlaRequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SlaRequirement create(SlaRequirement req) {

        // ❌ REMOVED invalid null checks for int/double
        // req.getMaxDeliveryDays() == null  ❌
        // req.getMinQualityScore() == null  ❌

        // Optional validation (VALID)
        if (req.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("Max delivery days must be > 0");
        }

        if (req.getMinQualityScore() < 0 || req.getMinQualityScore() > 1) {
            throw new IllegalArgumentException("Quality score must be between 0 and 1");
        }

        return repository.save(req);
    }

    @Override
    public List<SlaRequirement> getAll() {
        return repository.findAll();
    }

    @Override
    public SlaRequirement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SLA Requirement not found"));
    }

    @Override
    public List<SlaRequirement> getActiveSlas() {
        return repository.findAll()
                .stream()
                .filter(SlaRequirement::isActive) // ✅ FIXED
                .toList();
    }
}
