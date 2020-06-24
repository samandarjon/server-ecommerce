package uz.pdp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    List<Address> findAllByCreatedBy(UUID createdBy);

    Optional<Address> findByCreatedByAndActive(UUID createdBy, boolean active);
}
