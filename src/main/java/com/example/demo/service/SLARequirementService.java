package com.example.demo.service;

import com.example.demo.model.SLARequirement;

import java.util.List;

public interface SLARequirementService {

    SLARequirement createSLARequirement(SLARequirement slaRequirement);

    SLARequirement getSLARequirementById(Long id);

    List<SLARequirement> getAllSLARequirements();

    SLARequirement updateSLA(Long id, SLARequirement updated);

    void deleteSLARequirement(Long id);
}
