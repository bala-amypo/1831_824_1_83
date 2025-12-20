package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<SLARequirement> create(
            @RequestBody SLARequirement slaRequirement) {
        return ResponseEntity.ok(service.create(slaRequirement));
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<SLARequirement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<SLARequirement>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ✅ DEACTIVATE (soft delete)
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<SLARequirement> deactivate(@PathVariable Long id) {
        return ResponseEntity.ok(service.deactivateRequirement(id));
    }
}
