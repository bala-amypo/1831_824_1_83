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

    // CREATE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vendor updateVendor(
            @PathVariable Long id,
            @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    // GET ALL
    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    // DEACTIVATE
    @PutMapping("/{id}/deactivate")
    public Vendor deactivateVendor(@PathVariable Long id) {
        return service.deactivateVendor(id);
    }
}
