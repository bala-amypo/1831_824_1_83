package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.UniqueConstraint;

import java.util.List;

@Service
@Transactional
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repo;

    // Constructor injection
    public SLARequirementServiceImpl(SLARequirementRepository repo) {
        this.repo = repo;
    }

    // ---------------- CREATE ----------------
    @Override
    public SLARequirement createRequirement(SLARequirement req) {

        // Validate days > 0
        if (req.getMaxDeliveryDays() == null || req.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("maxDeliveryDays must be greater than 0");
        }

        // Validate score 0–100
        if (req.getMinQualityScore() == null ||
                req.getMinQualityScore() < 0 ||
                req.getMinQualityScore() > 100) {
            throw new IllegalArgumentException("minQualityScore must be between 0 and 100");
        }

        // Check duplicate name
        repo.findByRequirementName(req.getRequirementName())
                .ifPresent(r -> {
                    throw new IllegalStateException("requirementName already exists");
                });

        // Default active = true
        if (req.getActive() == null) {
            req.setActive(true);
        }

        return repo.save(req);
    }

    // ---------------- UPDATE ----------------
    @Override
    public SLARequirement updateRequirement(Long id, SLARequirement req) {

        SLARequirement existing = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SLARequirement not found with id " + id));

        // Check duplicate name (excluding self)
        repo.findByRequirementName(req.getRequirementName())
                .ifPresent(other -> {
                    if (!other.getId().equals(id)) {
                        throw new IllegalStateException("requirementName already exists");
                    }
                });

        // Re-validate rules
        if (req.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("maxDeliveryDays must be greater than 0");
        }

        if (req.getMinQualityScore() < 0 || req.getMinQualityScore() > 100) {
            throw new IllegalArgumentException("minQualityScore must be between 0 and 100");
        }

        // Update fields
        existing.setRequirementName(req.getRequirementName());
        existing.setDescription(req.getDescription());
        existing.setMaxDeliveryDays(req.getMaxDeliveryDays());
        existing.setMinQualityScore(req.getMinQualityScore());
        existing.setActive(req.getActive());

        return repo.save(existing);
    }

    // ---------------- GET BY ID ----------------
    @Override
    public SLARequirement getRequirementById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SLARequirement not found with id " + id));
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<SLARequirement> getAllRequirements() {
        return repo.findAll();
    }

    // ---------------- DEACTIVATE ----------------
    @Override
    public void deactivateRequirement(Long id) {
        SLARequirement existing = getRequirementById(id);
        existing.setActive(false);
        repo.save(existing);
    }
}
