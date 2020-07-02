package uz.pdp.ecommerce.payload;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
