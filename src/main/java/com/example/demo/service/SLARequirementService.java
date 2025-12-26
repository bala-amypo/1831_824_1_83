// package com.example.demo.service;
// import com.example.demo.model.SLARequirement;
// import java.util.List;

// public interface SLARequirementService {
//     SLARequirement createRequirement(SLARequirement req);
//     SLARequirement updateRequirement(Long id, SLARequirement req);
//     SLARequirement getRequirementById(Long id);
//     List<SLARequirement> getAllRequirements();
//     SLARequirement deactivateRequirement(Long id);
// }
package com.example.demo.service;

import com.example.demo.model.SLARequirement;
import java.util.List;

public interface SLARequirementService {

    SLARequirement createRequirement(SLARequirement requirement);

    SLARequirement updateRequirement(Long id, SLARequirement requirement);

    SLARequirement getRequirementById(Long id);

    List<SLARequirement> getAllRequirements();

    void deactivateRequirement(Long id);
}
