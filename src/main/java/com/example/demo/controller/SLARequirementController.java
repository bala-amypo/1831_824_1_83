package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    @Autowired
    private SLARequirementRepository slaRequirementRepository;

    // CREATE
    @PostMapping
    public SLARequirement createSLA(@RequestBody SLARequirement slaRequirement) {
        // Do NOT set id manually, it will auto-increment
        return slaRequirementRepository.save(slaRequirement);
    }

    // GET ALL
    @GetMapping
    public List<SLARequirement> getAllSLA() {
        return slaRequirementRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Optional<SLARequirement> getSLAById(@PathVariable Long id) {
        return slaRequirementRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public SLARequirement updateSLA(@PathVariable Long id, @RequestBody SLARequirement slaDetails) {
        SLARequirement sla = slaRequirementRepository.findById(id).orElseThrow();
        sla.setRequirementName(slaDetails.getRequirementName());
        sla.setDescription(slaDetails.getDescription());
        sla.setMaxDeliveryDays(slaDetails.getMaxDeliveryDays());
        sla.setMinQualityScore(slaDetails.getMinQualityScore());
        sla.setActive(slaDetails.getActive());
        return slaRequirementRepository.save(sla);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteSLA(@PathVariable Long id) {
        slaRequirementRepository.deleteById(id);
    }
}
