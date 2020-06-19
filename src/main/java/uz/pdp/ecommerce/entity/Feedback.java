package uz.pdp.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Feedback extends AGenerator {
    private String message;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
