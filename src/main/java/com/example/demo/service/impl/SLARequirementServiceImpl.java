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
    public SLARequirement create(SLARequirement sla) {
        // ❌ no null checks for int/double
        if (sla.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("Max delivery days must be > 0");
        }

        if (sla.getMinQualityScore() < 0 || sla.getMinQualityScore() > 1) {
            throw new IllegalArgumentException("Quality score must be between 0 and 1");
        }

        return repository.save(sla);
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
    public SLARequirement deactivateRequirement(Long id) {
        SLARequirement sla = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SLA Requirement not found"));

        sla.setActive(false);
        return repository.save(sla);
    }
}
