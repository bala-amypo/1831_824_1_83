package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService service;

    // 1. Create Vendor
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    // 2. Update Vendor
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vendor updateVendor(@PathVariable Long id,
                               @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    // 3. Get Vendor by ID
    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    // 4. Get All Vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    // 5. Deactivate Vendor
    @PutMapping("/{id}/deactivate")
    public void deactivateVendor(@PathVariable Long id) {
        service.deactivateVendor(id);
    }
}
