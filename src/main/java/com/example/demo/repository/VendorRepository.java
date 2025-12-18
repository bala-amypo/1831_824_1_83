package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{
     boolean existsByName(String name);
}