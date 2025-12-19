package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    @PostMapping
    public SLARequirement create(@RequestBody SLARequirement slaRequirement) {
        return service.createSLARequirement(slaRequirement);
    }

    @GetMapping("/{id}")
    public SLARequirement getById(@PathVariable Long id) {
        return service.getSLARequirementById(id);
    }

    @GetMapping
    public List<SLARequirement> getAll() {
        return service.getAllSLARequirements();
    }

    @PutMapping("/{id}/status")
    public SLARequirement updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateSLAStatus(id, active);
    }
}
