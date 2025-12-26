package com.example.demo.controller;
import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    @Autowired
    private SLARequirementService service;

    @PostMapping
    public ResponseEntity<SLARequirement> create(@RequestBody SLARequirement req) {
        return ResponseEntity.ok(service.createRequirement(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SLARequirement> update(@PathVariable Long id, @RequestBody SLARequirement req) {
        return ResponseEntity.ok(service.updateRequirement(id, req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SLARequirement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRequirementById(id));
    }

    @GetMapping
    public ResponseEntity<List<SLARequirement>> getAll() {
        return ResponseEntity.ok(service.getAllRequirements());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<SLARequirement> deactivate(@PathVariable Long id) {
        return ResponseEntity.ok(service.deactivateRequirement(id));
    }
}
// package com.example.demo.controller;

// import com.example.demo.model.SLARequirement;
// import com.example.demo.service.SLARequirementService;

// import java.util.List;

// public class SLARequirementController {

//     private final SLARequirementService service;

//     public SLARequirementController(SLARequirementService service) {
//         this.service = service;
//     }

//     public SLARequirement create(SLARequirement req) {
//         return service.createRequirement(req);
//     }

//     public SLARequirement update(Long id, SLARequirement req) {
//         return service.updateRequirement(id, req);
//     }

//     public SLARequirement getById(Long id) {
//         return service.getRequirementById(id);
//     }

//     public List<SLARequirement> getAll() {
//         return service.getAllRequirements();
//     }

//     public void deactivate(Long id) {
//         service.deactivateRequirement(id);
//     }
// }
