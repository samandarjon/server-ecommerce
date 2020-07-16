package uz.pdp.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.enums.OrderType;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Order extends AGenerator  {

    @ManyToOne
    private Product product;
    @Column(nullable = false)

    private int amount;

    @Enumerated(value = EnumType.STRING)
    private OrderType orderType = OrderType.NEW;

    private boolean consumerSeen;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    public Order(Product product, int amount, OrderType orderType, boolean consumerSeen, Address address) {
        this.product = product;
        this.amount = amount;
        this.orderType = orderType;
        this.consumerSeen = consumerSeen;
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public boolean isConsumerSeen() {
        return consumerSeen;
    }

    public void setConsumerSeen(boolean consumerSeen) {
        this.consumerSeen = consumerSeen;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order() {
    }

}
