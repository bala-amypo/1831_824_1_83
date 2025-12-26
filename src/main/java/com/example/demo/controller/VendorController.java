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
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@Tag(name = "Vendors")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @PostMapping
    public Vendor create(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    @PutMapping("/{id}")
    public Vendor update(@PathVariable Long id, @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    @GetMapping("/{id}")
    public Vendor getById(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    @GetMapping
    public List<Vendor> getAll() {
        return service.getAllVendors();
    }

    // ✅ FIXED: void method → no return
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVendor(id);
    }

    // ✅ FIXED: void method → no return
    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam Boolean active) {
        service.updateVendorStatus(id, active);
    }
}
