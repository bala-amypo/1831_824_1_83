package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;

@RestController
@RequestMapping("/slas")
public class SLARequirementController {

    @Autowired
    private SLARequirementService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public SLARequirement createSLA(@RequestBody SLARequirement sla) {
        return service.createSLA(sla);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SLARequirement updateSLA(@PathVariable Long id,
                                    @RequestBody SLARequirement sla) {
        return service.updateSLA(id, sla);
    }

    @GetMapping("/{id}")
    public SLARequirement getSLAById(@PathVariable Long id) {
        return service.getSLAById(id);
    }

    @GetMapping
    public List<SLARequirement> getAllSLAs() {
        return service.getAllSLAs();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateSLA(@PathVariable Long id) {
        service.deactivateSLA(id);
    }
}
