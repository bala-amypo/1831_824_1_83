// package com.example.demo.service.impl;
// import com.example.demo.model.SLARequirement;
// import com.example.demo.repository.SLARequirementRepository;
// import com.example.demo.service.SLARequirementService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class SLARequirementServiceImpl implements SLARequirementService {

//     @Autowired
//     private SLARequirementRepository repository;

//     @Override
//     public SLARequirement createRequirement(SLARequirement req) {
//         if (req.getMaxDeliveryDays() <= 0) throw new IllegalArgumentException("maxDeliveryDays must be > 0");
//         if (req.getMinQualityScore() < 0 || req.getMinQualityScore() > 100)
//             throw new IllegalArgumentException("minQualityScore must be 0-100");

//         Optional<SLARequirement> existing = repository.findByRequirementName(req.getRequirementName());
//         if (existing.isPresent()) throw new IllegalArgumentException("Requirement name already exists");

//         if (req.getActive() == null) req.setActive(true);
//         req.setId(null); 
//         return repository.save(req);
//     }

//     @Override
//     public SLARequirement updateRequirement(Long id, SLARequirement req) {
//         SLARequirement existing = repository.findById(id)
//                 .orElseThrow(() -> new IllegalArgumentException("Requirement not found"));

//         Optional<SLARequirement> byName = repository.findByRequirementName(req.getRequirementName());
//         if (byName.isPresent() && !byName.get().getId().equals(id))
//             throw new IllegalArgumentException("Requirement name already exists");

//         existing.setRequirementName(req.getRequirementName());
//         existing.setDescription(req.getDescription());
//         existing.setMaxDeliveryDays(req.getMaxDeliveryDays());
//         existing.setMinQualityScore(req.getMinQualityScore());
//         existing.setActive(req.getActive() != null ? req.getActive() : true);

//         return repository.save(existing);
//     }

//     @Override
//     public SLARequirement getRequirementById(Long id) {
//         return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Requirement not found"));
//     }

//     @Override
//     public List<SLARequirement> getAllRequirements() {
//         return repository.findAll();
//     }

//     @Override
//     public SLARequirement deactivateRequirement(Long id) {
//         SLARequirement existing = repository.findById(id)
//                 .orElseThrow(() -> new IllegalArgumentException("Requirement not found"));
//         existing.setActive(false);
//         return repository.save(existing);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;

import java.util.List;

public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SLARequirement createRequirement(SLARequirement requirement) {
        if (repository.existsByRequirementName(requirement.getRequirementName())) {
            throw new IllegalArgumentException("unique");
        }
        if (requirement.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("Max delivery days");
        }
        if (requirement.getMinQualityScore() < 0 || requirement.getMinQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score");
        }
        return repository.save(requirement);
    }

    @Override
    public SLARequirement updateRequirement(Long id, SLARequirement requirement) {
        SLARequirement existing = getRequirementById(id);

        if (requirement.getRequirementName() != null &&
                !requirement.getRequirementName().equals(existing.getRequirementName())) {

            if (repository.existsByRequirementName(requirement.getRequirementName())) {
                throw new IllegalArgumentException("unique");
            }
            existing.setRequirementName(requirement.getRequirementName());
        }
        return repository.save(existing);
    }

    @Override
    public SLARequirement getRequirementById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Override
    public List<SLARequirement> getAllRequirements() {
        return repository.findAll();
    }

    @Override
    public void deactivateRequirement(Long id) {
        SLARequirement req = getRequirementById(id);
        req.setActive(false);
        repository.save(req);
    }
}
