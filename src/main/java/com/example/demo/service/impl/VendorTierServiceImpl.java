package com.example.demo.service.impl;

import com.example.demo.model.VendorTier;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorTierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorTierServiceImpl implements VendorTierService {

    private final VendorTierRepository repository;

    public VendorTierServiceImpl(VendorTierRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendorTier createTier(VendorTier tier) {
        validateThreshold(tier.getMinScoreThreshold());
        tier.setActive(true);
        return repository.save(tier);
    }

    @Override
    public VendorTier updateTier(Long id, VendorTier tier) {
        VendorTier existing = getTierById(id);
        validateThreshold(tier.getMinScoreThreshold());

        existing.setTierName(tier.getTierName());
        existing.setMinScoreThreshold(tier.getMinScoreThreshold());
        existing.setDescription(tier.getDescription());

        return repository.save(existing);
    }

    @Override
    public VendorTier getTierById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VendorTier not found"));
    }

    @Override
    public List<VendorTier> getAllTiers() {
        return repository.findAll();
    }

    @Override
    public void deactivateTier(Long id) {
        VendorTier tier = getTierById(id);
        tier.setActive(false);
        repository.save(tier);
    }

    private void validateThreshold(Double threshold) {
        if (threshold < 0 || threshold > 100) {
            throw new IllegalArgumentException("minScoreThreshold must be between 0 and 100");
        }
    }
}
