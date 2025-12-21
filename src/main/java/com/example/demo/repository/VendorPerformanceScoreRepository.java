package com.example.demo.repository;

import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendorPerformanceScoreRepository
        extends JpaRepository<VendorPerformanceScore, Long> {

    Optional<VendorPerformanceScore>
        findTopByVendorOrderByCalculatedAtDesc(Vendor vendor);

    List<VendorPerformanceScore>
        findByVendorOrderByCalculatedAtDesc(Vendor vendor);
}
