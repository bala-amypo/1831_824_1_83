package com.example.demo.service;
import java.util.List;
import com.example.demo.model.VendorPerformance;
public interface VendorPerformanceService{
   VendorPerformanceScore calculateScore(Long vendorId);
   VendorPerformanceScore getLatestScore(Long vendorId);
   List<VendorPerformanceScore> getScoresForVendor(Long vendorId);
}