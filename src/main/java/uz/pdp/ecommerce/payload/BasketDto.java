package uz.pdp.ecommerce.payload;


public class BasketDto {
    private Long id;
    private ProductDto product;

    public BasketDto(Long id, ProductDto product) {
        this.id = id;
        this.product = product;
    }

    public BasketDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
