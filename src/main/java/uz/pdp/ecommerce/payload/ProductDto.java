package uz.pdp.ecommerce.payload;


import lombok.Data;

import java.util.Map;

public class ProductDto {
    private String title;
    private String description;
    private double price;
    private Map<String, String> aboutMoreProduct;

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
}
