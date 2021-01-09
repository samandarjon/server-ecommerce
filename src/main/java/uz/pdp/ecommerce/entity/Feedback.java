package uz.pdp.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
public class Feedback extends AGenerator {
    @Column(nullable = false)
    private String message;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Product product;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
