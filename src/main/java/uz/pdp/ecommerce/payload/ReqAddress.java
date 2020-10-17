package uz.pdp.ecommerce.payload;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class ReqAddress {
    private UUID id;
    private Integer zipCode;
    @NotBlank(message = "Viloyatni kiritish majburiy.")
    private String province;
    @NotBlank(message = "Shaxar(tuman)ni kiritish majburiy.")
    private String city;
    @NotBlank(message = "Qayerda yashashingizni ko`rsating.")
    private String home;
    private boolean isActive;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
