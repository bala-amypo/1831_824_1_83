package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    // ✅ Constructor Injection (REQUIRED)
    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public SLARequirement createSLA(@RequestBody SLARequirement slaRequirement) {
        return service.createSLARequirement(slaRequirement);
    }

    // GET ALL
    @GetMapping
    public List<SLARequirement> getAllSLA() {
        return service.getAllSLARequirements();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public SLARequirement getSLAById(@PathVariable Long id) {
        return service.getSLARequirementById(id);
    }

    // UPDATE STATUS ONLY
    @PutMapping("/{id}/status")
    public SLARequirement updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateSLAStatus(id, active);
    }
}
