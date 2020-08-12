package uz.pdp.ecommerce.payload;


import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductDto {
    private UUID id;
    @NotBlank(message = "Title mustn't blank")
    private String title;
    @NotBlank(message = "Description mustn't blank")
    private String description;
    private List<UUID> files;
    @NotBlank(message = "Price mustn't blank")
    private double price;
    private Map<String, String> aboutMoreProduct;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, String> getAboutMoreProduct() {
        return aboutMoreProduct;
    }

    public void setAboutMoreProduct(Map<String, String> aboutMoreProduct) {
        this.aboutMoreProduct = aboutMoreProduct;
    }

    public List<UUID> getFiles() {
        return files;
    }

    public void setFiles(List<UUID> files) {
        this.files = files;
    }
}
