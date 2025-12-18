
@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository repo;   // Repository for DB operations

    @Override
    public Vendor createVendor(Vendor vendor) {
        // Check duplicate vendor name
        if (repo.existsByName(vendor.getName())) {
            throw new RuntimeException("Duplicate vendor");
        }
        vendor.setActive(true);      // Default active
        return repo.save(vendor);    // Save to DB
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorById(id); // Fetch vendor
        existing.setName(vendor.getName());  // Update fields
        return repo.save(existing);
    }

    @Override
    public Vendor getVendorById(Long id) {
        // Fetch vendor or throw exception
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repo.findAll();       // Fetch all vendors
    }

    @Override
    public void deactivateVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendor.setActive(false);     // Soft delete
        repo.save(vendor);
    }
}
