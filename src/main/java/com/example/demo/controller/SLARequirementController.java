package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    // Constructor Injection
    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    // ---------------- CREATE ----------------
    // POST /
    @PostMapping
    public SLARequirement createRequirement(
            @RequestBody SLARequirement req) {
        return service.createRequirement(req);
    }

    // ---------------- UPDATE ----------------
    // PUT /{id}
    @PutMapping("/{id}")
    public SLARequirement updateRequirement(
            @PathVariable Long id,
            @RequestBody SLARequirement req) {
        return service.updateRequirement(id, req);
    }

    // ---------------- GET BY ID ----------------
    // GET /{id}
    @GetMapping("/{id}")
    public SLARequirement getRequirementById(
            @PathVariable Long id) {
        return service.getRequirementById(id);
    }

    // ---------------- GET ALL ----------------
    // GET /
    @GetMapping
    public List<SLARequirement> getAllRequirements() {
        return service.getAllRequirements();
    }

    // ---------------- DEACTIVATE ----------------
    // PUT /{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public void deactivateRequirement(
            @PathVariable Long id) {
        service.deactivateRequirement(id);
    }
}
