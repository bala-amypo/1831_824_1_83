package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.repository.VendorPerformanceScoreRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    private final VendorRepository vendorRepository;
    private final VendorPerformanceScoreRepository scoreRepository;

    public VendorPerformanceScoreServiceImpl(
            VendorRepository vendorRepository,
            VendorPerformanceScoreRepository scoreRepository) {
        this.vendorRepository = vendorRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public VendorPerformanceScore calculateScore(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        // TEMP calculation (since DeliveryEvaluation is skipped)
        double onTime = 80.0;
        double quality = 90.0;

        // weights: 50% + 50%
        double overall = (onTime * 0.5) + (quality * 0.5);

        VendorPerformanceScore score = new VendorPerformanceScore();
        score.setVendor(vendor);
        score.setOnTimePercentage(onTime);
        score.setQualityCompliancePercentage(quality);
        score.setOverallScore(overall);
        score.setCalculatedAt(LocalDateTime.now());

        return scoreRepository.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        return scoreRepository.findTopByVendorOrderByCalculatedAtDesc(vendor)
                .orElseThrow(() -> new RuntimeException("No score found"));
    }

    @Override
    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        return scoreRepository.findByVendorOrderByCalculatedAtDesc(vendor);
    }
}
