package uz.pdp.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ecommerce.entity.enums.OrderType;
import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
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
}
