package uz.pdp.ecommerce.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class ReqAddress {
    private Integer zipCode;
    @NotBlank(message = "Viloyatni kiritish majburiy.")
    private String province;
    @NotBlank(message = "Shaxar(tuman)ni kiritish majburiy.")
    private String city;
    @NotBlank(message = "Qayerda yashashingizni ko`rsating.")
    private String home;
    private boolean isActive;
}
