// package com.example.demo.service.impl;
// import com.example.demo.model.Vendor;
// import com.example.demo.repository.VendorRepository;
// import com.example.demo.service.VendorService;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import java.util.List;

// @Service
// @Transactional
// public class VendorServiceImpl implements VendorService {

//     private final VendorRepository repo;

//     public VendorServiceImpl(VendorRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public Vendor createVendor(Vendor vendor) {
//         return repo.save(vendor);
//     }

//     @Override
//     public Vendor getVendorById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Vendor not found"));
//     }

//     @Override
//     public List<Vendor> getAllVendors() {
//         return repo.findAll();
//     }

//     @Override
//     public Vendor updateVendorStatus(Long id, Boolean active) {
//         Vendor vendor = getVendorById(id);
//         vendor.setActive(active);
//         return repo.save(vendor);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;

import java.util.List;

public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    public VendorServiceImpl(VendorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        if (repository.existsByName(vendor.getName())) {
            throw new IllegalArgumentException("unique");
        }
        return repository.save(vendor);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorById(id);

        if (vendor.getContactEmail() != null) {
            existing.setContactEmail(vendor.getContactEmail());
        }
        if (vendor.getContactPhone() != null) {
            existing.setContactPhone(vendor.getContactPhone());
        }
        if (vendor.getName() != null && !vendor.getName().equals(existing.getName())) {
            if (repository.existsByName(vendor.getName())) {
                throw new IllegalArgumentException("unique");
            }
            existing.setName(vendor.getName());
        }

        return repository.save(existing);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    @Override
    public void deactivateVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendor.setActive(false);
        repository.save(vendor);
    }
}
