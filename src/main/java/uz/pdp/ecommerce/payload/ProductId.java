package uz.pdp.ecommerce.payload;

import javax.validation.constraints.NotBlank;

public class ProductId {
    @NotBlank(message = "Mahuslot bosilmadi")
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
