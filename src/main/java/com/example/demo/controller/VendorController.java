// package com.example.demo.controller;
// import com.example.demo.model.Vendor;
// import com.example.demo.service.VendorService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;

// @RestController
// @RequestMapping("/api/vendors")
// public class VendorController {

//     private final VendorService vendorService;

//     public VendorController(VendorService vendorService) {
//         this.vendorService = vendorService;
//     }

//     @PostMapping
//     public Vendor createVendor(@RequestBody Vendor vendor) {
//         return vendorService.createVendor(vendor);
//     }

//     @GetMapping("/{id}")
//     public Vendor getVendorById(@PathVariable Long id) {
//         return vendorService.getVendorById(id);
//     }

//     @GetMapping
//     public List<Vendor> getAllVendors() {
//         return vendorService.getAllVendors();
//     }

//     @PutMapping("/{id}/status")
//     public Vendor updateVendorStatus(
//             @PathVariable Long id,
//             @RequestParam Boolean active) {
//         return vendorService.updateVendorStatus(id, active);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

import java.util.List;

public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    public Vendor create(Vendor vendor) {
        return service.createVendor(vendor);
    }

    public Vendor update(Long id, Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    public Vendor getById(Long id) {
        return service.getVendorById(id);
    }

    public List<Vendor> getAll() {
        return service.getAllVendors();
    }

    public void deactivate(Long id) {
        service.deactivateVendor(id);
    }
}
