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
public class Product extends AGenerator {
    private String title;
    private String description;
    //    TODO Attachment product images;
    private double price;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Feedback> feedback;

    @ElementCollection
    private Map<String, String> aboutMoreProduct;

    public Product() {
    }

    public Product(String title, String description, double price, Category category, List<Feedback> feedback, Map<String, String> aboutMoreProduct) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.feedback = feedback;
        this.aboutMoreProduct = aboutMoreProduct;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public Map<String, String> getAboutMoreProduct() {
        return aboutMoreProduct;
    }

    public void setAboutMoreProduct(Map<String, String> aboutMoreProduct) {
        this.aboutMoreProduct = aboutMoreProduct;
    }
}
