// package com.example.demo.repository;
// import com.example.demo.model.VendorTier;
// import org.springframework.data.jpa.repository.JpaRepository;
// public interface VendorTierRepository extends JpaRepository<VendorTier, Long> {
// }
package com.example.demo.repository;

import com.example.demo.model.VendorTier;

import java.util.List;
import java.util.Optional;

public interface VendorTierRepository {

    VendorTier save(VendorTier tier);

    Optional<VendorTier> findById(Long id);

    boolean existsByTierName(String tierName);

    List<VendorTier> findByActiveTrueOrderByMinScoreThresholdDesc();
}

