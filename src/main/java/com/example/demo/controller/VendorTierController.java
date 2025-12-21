package com.example.demo.controller;

import com.example.demo.model.VendorTier;
import com.example.demo.service.VendorTierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiers")
public class VendorTierController {

    private final VendorTierService service;

    public VendorTierController(VendorTierService service) {
        this.service = service;
    }

    // POST /api/tiers
    @PostMapping
    public VendorTier createTier(@RequestBody VendorTier tier) {
        return service.createTier(tier);
    }

    // PUT /api/tiers/{id}
    @PutMapping("/{id}")
    public VendorTier updateTier(@PathVariable Long id,
                                 @RequestBody VendorTier tier) {
        return service.updateTier(id, tier);
    }

    // GET /api/tiers/{id}
    @GetMapping("/{id}")
    public VendorTier getTier(@PathVariable Long id) {
        return service.getTierById(id);
    }

    // GET /api/tiers
    @GetMapping
    public List<VendorTier> getAllTiers() {
        return service.getAllTiers();
    }

    // PUT /api/tiers/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public void deactivateTier(@PathVariable Long id) {
        service.deactivateTier(id);
    }
}
