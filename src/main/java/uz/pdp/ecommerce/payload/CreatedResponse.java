package uz.pdp.ecommerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CreatedResponse {
    private String id;
    private String message;

}
