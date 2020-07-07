package uz.pdp.ecommerce.payload;


import uz.pdp.ecommerce.entity.enums.OrderType;

import java.util.UUID;

public class OrderDto {
    private UUID productId;
    private int amount;
    private UUID addressId;
    private OrderType orderType;

    public OrderDto() {
    }

    public OrderDto(UUID productId, int amount, UUID addressId) {
        this.productId = productId;
        this.amount = amount;
        this.addressId = addressId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }


}
