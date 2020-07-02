package uz.pdp.ecommerce.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.ecommerce.entity.enums.RoleName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements GrantedAuthority, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
