package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repo;

    public VendorServiceImpl(VendorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        return repo.save(vendor);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repo.findAll();
    }

    @Override
    public Vendor updateVendorStatus(Long id, Boolean active) {
        Vendor vendor = getVendorById(id);
        vendor.setActive(active);
        return repo.save(vendor);
    }
}
