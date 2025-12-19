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
                .orElseThrow(() -> new RuntimeException("SLARequirement not found"));
    }

    @Override
    public List<SLARequirement> getAllSLARequirements() {
        return repo.findAll();
    }

    @Override
    public SLARequirement updateSLAStatus(Long id, Boolean active) {
        SLARequirement sla = getSLARequirementById(id);
        sla.setActive(active);
        return repo.save(sla);
    }
}
