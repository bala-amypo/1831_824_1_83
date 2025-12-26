// package com.example.demo.repository;

// import com.example.demo.model.*;
// import org.springframework.data.jpa.repository.*;
// import org.springframework.data.repository.query.Param;
// import java.util.List;

// public interface DeliveryEvaluationRepository
//         extends JpaRepository<DeliveryEvaluation, Long> {

//     List<DeliveryEvaluation> findByVendorId(Long vendorId);

//     List<DeliveryEvaluation> findBySlaRequirementId(Long slaId);

//     @Query("SELECT d FROM DeliveryEvaluation d WHERE d.vendor = :vendor AND d.qualityScore >= :minScore")
//     List<DeliveryEvaluation> findHighQualityDeliveries(
//             @Param("vendor") Vendor vendor,
//             @Param("minScore") Double minScore
//     );

//     @Query("SELECT d FROM DeliveryEvaluation d WHERE d.slaRequirement = :sla AND d.meetsDeliveryTarget = true")
//     List<DeliveryEvaluation> findOnTimeDeliveries(@Param("sla") SLARequirement sla);
// }
package com.example.demo.repository;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.SLARequirement;
import com.example.demo.model.Vendor;

import java.util.List;

public interface DeliveryEvaluationRepository {

    DeliveryEvaluation save(DeliveryEvaluation evaluation);

    List<DeliveryEvaluation> findByVendorId(Long vendorId);

    List<DeliveryEvaluation> findBySlaRequirementId(Long slaRequirementId);

    List<DeliveryEvaluation> findHighQualityDeliveries(Vendor vendor, Double minQualityScore);

    List<DeliveryEvaluation> findOnTimeDeliveries(SLARequirement slaRequirement);
}
