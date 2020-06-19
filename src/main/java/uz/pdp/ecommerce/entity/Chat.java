package uz.pdp.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Chat extends AGenerator {
    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private UUID receiver;

}
