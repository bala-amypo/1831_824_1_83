// package com.example.demo.service.impl;
// import com.example.demo.model.Vendor;
// import com.example.demo.model.VendorPerformanceScore;
// import com.example.demo.repository.VendorPerformanceScoreRepository;
// import com.example.demo.repository.VendorRepository;
// import com.example.demo.service.VendorPerformanceScoreService;
// import org.springframework.stereotype.Service;
// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class VendorPerformanceScoreServiceImpl
//         implements VendorPerformanceScoreService {

//     private final VendorRepository vendorRepository;
//     private final VendorPerformanceScoreRepository scoreRepository;

//     public VendorPerformanceScoreServiceImpl(
//             VendorRepository vendorRepository,
//             VendorPerformanceScoreRepository scoreRepository) {
//         this.vendorRepository = vendorRepository;
//         this.scoreRepository = scoreRepository;
//     }

//     @Override
//     public VendorPerformanceScore calculateScore(Long vendorId) {

//         Vendor vendor = vendorRepository.findById(vendorId)
//                 .orElseThrow(() -> new RuntimeException("Vendor not found"));

//         double onTime = 80.0;
//         double quality = 90.0;

//         double overall = (onTime * 0.5) + (quality * 0.5);

//         VendorPerformanceScore score = new VendorPerformanceScore();
//         score.setVendor(vendor);
//         score.setOnTimePercentage(onTime);
//         score.setQualityCompliancePercentage(quality);
//         score.setOverallScore(overall);
//         score.setCalculatedAt(LocalDateTime.now());

//         return scoreRepository.save(score);
//     }

//     @Override
//     public VendorPerformanceScore getLatestScore(Long vendorId) {
//         Vendor vendor = vendorRepository.findById(vendorId)
//                 .orElseThrow(() -> new RuntimeException("Vendor not found"));

//         return scoreRepository.findTopByVendorOrderByCalculatedAtDesc(vendor)
//                 .orElseThrow(() -> new RuntimeException("No score found"));
//     }

//     @Override
//     public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
//         Vendor vendor = vendorRepository.findById(vendorId)
//                 .orElseThrow(() -> new RuntimeException("Vendor not found"));

//         return scoreRepository.findByVendorOrderByCalculatedAtDesc(vendor);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.model.VendorTier;
import com.example.demo.repository.*;
import com.example.demo.service.VendorPerformanceScoreService;

import java.time.LocalDateTime;
import java.util.List;

public class VendorPerformanceScoreServiceImpl implements VendorPerformanceScoreService {

    private final VendorPerformanceScoreRepository vendorPerformanceScoreRepository;
    private final DeliveryEvaluationRepository deliveryEvaluationRepository;
    private final VendorRepository vendorRepository;
    private final VendorTierRepository vendorTierRepository;

    // 🔴 THIS CONSTRUCTOR MUST MATCH THE TEST EXACTLY
    public VendorPerformanceScoreServiceImpl(
            VendorPerformanceScoreRepository vendorPerformanceScoreRepository,
            DeliveryEvaluationRepository deliveryEvaluationRepository,
            VendorRepository vendorRepository,
            VendorTierRepository vendorTierRepository
    ) {
        this.vendorPerformanceScoreRepository = vendorPerformanceScoreRepository;
        this.deliveryEvaluationRepository = deliveryEvaluationRepository;
        this.vendorRepository = vendorRepository;
        this.vendorTierRepository = vendorTierRepository;
    }

    @Override
    public VendorPerformanceScore calculateScore(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        var evaluations = deliveryEvaluationRepository.findByVendorId(vendorId);

        double total = evaluations.size();
        double onTime = evaluations.stream().filter(e -> Boolean.TRUE.equals(e.getMeetsDeliveryTarget())).count();
        double quality = evaluations.stream().filter(e -> Boolean.TRUE.equals(e.getMeetsQualityTarget())).count();

        double onTimePercent = total == 0 ? 0 : (onTime / total) * 100;
        double qualityPercent = total == 0 ? 0 : (quality / total) * 100;
        double overall = (onTimePercent + qualityPercent) / 2;

        VendorPerformanceScore score =
                new VendorPerformanceScore(vendor, onTimePercent, qualityPercent, overall);

        score.setCalculatedAt(LocalDateTime.now());

        // assign tier if exists
        List<VendorTier> tiers =
                vendorTierRepository.findByActiveTrueOrderByMinScoreThresholdDesc();

        for (VendorTier tier : tiers) {
            if (overall >= tier.getMinScoreThreshold()) {
                score.setVendorTier(tier);
                break;
            }
        }

        return vendorPerformanceScoreRepository.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        return vendorPerformanceScoreRepository
                .findByVendorOrderByCalculatedAtDesc(vendorId)
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        return vendorPerformanceScoreRepository
                .findByVendorOrderByCalculatedAtDesc(vendorId);
    }
}
