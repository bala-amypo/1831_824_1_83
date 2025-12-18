package com.example.demo.service.impl;
import com.example.demo.model.Vendor;
import java.util.List;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository repo;  

    @Override
    public Vendor createVendor(Vendor vendor) {
        if (repo.existsByName(vendor.getName())) {
            throw new RuntimeException("Duplicate vendor");
        }
        vendor.setActive(true);     
        return repo.save(vendor);    
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorById(id);
        existing.setName(vendor.getName());  
        return repo.save(existing);
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
    public void deactivateVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendor.setActive(false);    
        repo.save(vendor);
    }
}
