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

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.VendorPerformanceScoreRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorPerformanceScoreService;

import java.util.List;

public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    private final VendorRepository vendorRepository;
    private final VendorPerformanceScoreRepository scoreRepository;
    private final DeliveryEvaluationRepository evaluationRepository;
    private final VendorTierRepository tierRepository;

    public VendorPerformanceScoreServiceImpl(
            VendorRepository vendorRepository,
            VendorPerformanceScoreRepository scoreRepository,
            DeliveryEvaluationRepository evaluationRepository,
            VendorTierRepository tierRepository) {

        this.vendorRepository = vendorRepository;
        this.scoreRepository = scoreRepository;
        this.evaluationRepository = evaluationRepository;
        this.tierRepository = tierRepository;
    }

    @Override
    public VendorPerformanceScore calculateScore(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        List<DeliveryEvaluation> evaluations =
                evaluationRepository.findByVendorId(vendorId);

        long total = evaluations.size();
        long onTime = evaluations.stream()
                .filter(e -> Boolean.TRUE.equals(e.getMeetsDeliveryTarget()))
                .count();

        long quality = evaluations.stream()
                .filter(e -> Boolean.TRUE.equals(e.getMeetsQualityTarget()))
                .count();

        double onTimePct = total == 0 ? 0 : (onTime * 100.0 / total);
        double qualityPct = total == 0 ? 0 : (quality * 100.0 / total);
        double overall = (onTimePct + qualityPct) / 2;

        VendorPerformanceScore score =
                new VendorPerformanceScore(vendor, onTimePct, qualityPct, overall);

        return scoreRepository.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        return scoreRepository
                .findByVendorOrderByCalculatedAtDesc(vendorId)
                .get(0);
    }

    @Override
    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        return scoreRepository.findByVendorOrderByCalculatedAtDesc(vendorId);
    }
}
