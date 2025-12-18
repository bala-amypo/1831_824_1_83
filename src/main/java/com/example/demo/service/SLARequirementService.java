package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SLARequirement;

public interface SLARequirementService {

    SLARequirement createSLA(SLARequirement sla);

    SLARequirement updateSLA(Long id, SLARequirement sla);

    SLARequirement getSLAById(Long id);

    List<SLARequirement> getAllSLAs();

    void deactivateSLA(Long id);
}
