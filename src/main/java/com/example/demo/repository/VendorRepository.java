// package com.example.demo.repository;
// import com.example.demo.model.Vendor;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// @Repository
// public interface VendorRepository extends JpaRepository<Vendor, Long> {
// }
package com.example.demo.repository;

import com.example.demo.model.Vendor;
import java.util.List;
import java.util.Optional;

public interface VendorRepository {

    Vendor save(Vendor vendor);

    Optional<Vendor> findById(Long id);

    List<Vendor> findAll();

    boolean existsByName(String name);
}

