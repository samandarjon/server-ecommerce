package uz.pdp.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends AGenerator {
    private Integer zipCode;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String home;
}
