package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SLARequirement create(SLARequirement req) {

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
    public List<SLARequirement> getAll() {
        return repository.findAll();
    }

    @Override
    public SLARequirement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SLA Requirement not found"));
    }

    @Override
    public List<SLARequirement> getActiveSlas() {
        return repository.findAll()
                .stream()
                .filter(SLARequirement::isActive) // ✅ FIXED
                .toList();
    }
}
