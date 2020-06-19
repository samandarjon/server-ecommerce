package uz.pdp.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AGenerator {
    private String title;
    private String description;
    //    TODO Attachment product images;
    private double price;

    @ManyToOne
    private Category category;
    //    TODO Feedback;
    @OneToMany(mappedBy ="product" )
    private List<Feedback> feedback;

    @ElementCollection
    private Map<String, String> aboutMoreProduct;


}
