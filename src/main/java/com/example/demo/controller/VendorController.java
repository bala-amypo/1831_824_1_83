package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService service;

    
  
    @PostMapping(consumes = "application/json")
public Vendor createVendor(@RequestBody Vendor vendor) {
    return service.createVendor(vendor);
}



    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    
    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    
    @PutMapping("/{id}")
    public Vendor updateVendor(
            @PathVariable Long id,
            @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public void deactivateVendor(@PathVariable Long id) {
        service.deactivateVendor(id);
    }
}
