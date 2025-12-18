package com.example.demo.repository;
import 
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{
    
}