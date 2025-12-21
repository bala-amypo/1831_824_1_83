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

    @PostMapping
    public VendorTier createTier(@RequestBody VendorTier tier) {
        return service.createTier(tier);
    }

    @PutMapping("/{id}")
    public VendorTier updateTier(@PathVariable Long id,
                                 @RequestBody VendorTier tier) {
        return service.updateTier(id, tier);
    }

    @GetMapping("/{id}")
    public VendorTier getTier(@PathVariable Long id) {
        return service.getTierById(id);
    }

    @GetMapping
    public List<VendorTier> getAllTiers() {
        return service.getAllTiers();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateTier(@PathVariable Long id) {
        service.deactivateTier(id);
    }
}
