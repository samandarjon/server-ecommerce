package uz.pdp.ecommerce.payload;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateUserDto {
    @NotBlank(message = "Parol bo`sh bo`lmasligi kerak.")
    private String password;
    @NotBlank(message = "Tasdiqlovchi parol bo`sh bo`lmasligi kerak.")
    @Min(message = "Parol ", value = 4)
    private String password2;
    @NotBlank(message = "Telefon raqam bo`sh bo`lmasligi kerak.")
    private String phoneNumber;
    @NotBlank(message = "Familiya bo`sh bo`lmasligi kerak.")
    private String lastName;
    private String firstName;
}
