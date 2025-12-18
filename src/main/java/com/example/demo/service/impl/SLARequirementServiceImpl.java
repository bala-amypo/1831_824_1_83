package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;

@Service
public class SLARequirementServiceImpl implements SLARequirementService {

    @Autowired
    private SLARequirementRepository repo;

    @Override
    public SLARequirement createSLA(SLARequirement sla) {
        if (repo.existsByRequirementName(sla.getRequirementName())) {
            throw new RuntimeException("SLA already exists");
        }
        sla.setActive(true);
        return repo.save(sla);
    }

    @Override
    public SLARequirement updateSLA(Long id, SLARequirement sla) {
        SLARequirement existing = getSLAById(id);
        existing.setRequirementName(sla.getRequirementName());
        existing.setDescription(sla.getDescription());
        existing.setMaxDeliveryDays(sla.getMaxDeliveryDays());
        existing.setMinQualityScore(sla.getMinQualityScore());
        return repo.save(existing);
    }

    @Override
    public SLARequirement getSLAById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("SLA not found"));
    }

    @Override
    public List<SLARequirement> getAllSLAs() {
        return repo.findAll();
    }

    @Override
    public void deactivateSLA(Long id) {
        SLARequirement sla = getSLAById(id);
        sla.setActive(false);
        repo.save(sla);
    }
}
