package uz.pdp.ecommerce.payload;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class ProductId {
    @NotBlank(message = "Mahuslot bosilmadi")
    private UUID productId;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
}
