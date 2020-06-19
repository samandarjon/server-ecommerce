package uz.pdp.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.enums.OrderType;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "orders")
public class Order extends AGenerator implements Serializable {

    @ManyToOne
    private Product product;
    @Column(nullable = false)

    private int amount;

    @Enumerated(value = EnumType.STRING)
    private OrderType orderType = OrderType.NEW;

    private boolean consumerSeen;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

}
