package uz.pdp.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommerce.entity.Role;
import uz.pdp.ecommerce.entity.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);
}
