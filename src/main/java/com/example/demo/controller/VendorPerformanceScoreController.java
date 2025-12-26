// package com.example.demo.controller;
// import com.example.demo.model.VendorPerformanceScore;
// import com.example.demo.service.VendorPerformanceScoreService;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/scores")
// public class VendorPerformanceScoreController {

//     private final VendorPerformanceScoreService service;

//     public VendorPerformanceScoreController(
//             VendorPerformanceScoreService service) {
//         this.service = service;
//     }

//     @PostMapping("/calculate/{vendorId}")
//     public VendorPerformanceScore calculate(@PathVariable Long vendorId) {
//         return service.calculateScore(vendorId);
//     }

//     @GetMapping("/latest/{vendorId}")
//     public VendorPerformanceScore latest(@PathVariable Long vendorId) {
//         return service.getLatestScore(vendorId);
//     }

//     @GetMapping("/vendor/{vendorId}")
//     public List<VendorPerformanceScore> history(@PathVariable Long vendorId) {
//         return service.getScoresForVendor(vendorId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.service.VendorPerformanceScoreService;

import java.util.List;

public class VendorPerformanceScoreController {

    private final VendorPerformanceScoreService service;

    public VendorPerformanceScoreController(VendorPerformanceScoreService service) {
        this.service = service;
    }

    public VendorPerformanceScore calculate(Long vendorId) {
        return service.calculateScore(vendorId);
    }

    public VendorPerformanceScore latest(Long vendorId) {
        return service.getLatestScore(vendorId);
    }

    public List<VendorPerformanceScore> history(Long vendorId) {
        return service.getScoresForVendor(vendorId);
    }
}
