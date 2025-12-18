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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vendor updateVendor(
            @PathVariable Long id,
            @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    @PutMapping("/{id}/deactivate")
    public Vendor deactivateVendor(@PathVariable Long id) {
        return service.deactivateVendor(id);
    }
}
