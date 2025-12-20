package com.example.demo.service;

import com.example.demo.model.SLARequirement;

import java.util.List;

public interface SLARequirementService {

    SLARequirement create(SLARequirement sla);

    List<SLARequirement> getAll();

    SLARequirement getById(Long id);

    SLARequirement deactivateRequirement(Long id);
}
