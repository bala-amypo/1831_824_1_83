// package com.example.demo.repository;
// import com.example.demo.model.SLARequirement;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;
// public interface SLARequirementRepository extends JpaRepository<SLARequirement, Long> {
//     Optional<SLARequirement> findByRequirementName(String requirementName);
// }
package com.example.demo.repository;

import com.example.demo.model.SLARequirement;
import java.util.List;
import java.util.Optional;

public interface SLARequirementRepository {

    SLARequirement save(SLARequirement requirement);

    Optional<SLARequirement> findById(Long id);

    List<SLARequirement> findAll();

    boolean existsByRequirementName(String requirementName);
}
