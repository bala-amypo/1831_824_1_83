package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository repo;

    @Override
    public Vendor createVendor(Vendor vendor) {
        if (repo.existsByName(vendor.getName())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Vendor already exists"
            );
        }
        vendor.setActive(true);
        vendor.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        vendor.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return repo.save(vendor);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorById(id);

        existing.setName(vendor.getName());
        existing.setContactEmail(vendor.getContactEmail());
        existing.setContactPhone(vendor.getContactPhone());
        existing.setActive(vendor.isActive());
        existing.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return repo.save(existing);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Vendor not found with id " + id
                        ));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repo.findAll();
    }

    @Override
    public Vendor deactivateVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendor.setActive(false);
        vendor.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return repo.save(vendor);
    }
}
