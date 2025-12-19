package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repo;

    // Constructor Injection
    public SLARequirementServiceImpl(SLARequirementRepository repo) {
        this.repo = repo;
    }

    @Override
    public SLARequirement createSLARequirement(SLARequirement slaRequirement) {
        return repo.save(slaRequirement);
    }

    @Override
    public SLARequirement getSLARequirementById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SLARequirement not found with id " + id));
    }

    @Override
    public List<SLARequirement> getAllSLARequirements() {
        return repo.findAll();
    }

    @Override
    public SLARequirement updateSLA(Long id, SLARequirement updated) {
        SLARequirement existing = getSLARequirementById(id);

        existing.setRequirementName(updated.getRequirementName());
        existing.setDescription(updated.getDescription());
        existing.setMaxDeliveryDays(updated.getMaxDeliveryDays());
        existing.setMinQualityScore(updated.getMinQualityScore());
        existing.setActive(updated.getActive());

        return repo.save(existing);
    }

    @Override
    public void deleteSLARequirement(Long id) {
        SLARequirement sla = getSLARequirementById(id);
        repo.delete(sla);
    }
}
