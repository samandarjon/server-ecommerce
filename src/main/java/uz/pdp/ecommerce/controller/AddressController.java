package uz.pdp.ecommerce.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.entity.Address;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.CreatedResponse;
import uz.pdp.ecommerce.payload.ReqAddress;
import uz.pdp.ecommerce.security.CurrentUser;
import uz.pdp.ecommerce.service.AddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@ApiResponses(value = {@ApiResponse(responseCode = "404",
        content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = uz.pdp.ecommerce.payload.ApiResponse.class))),
        @ApiResponse(responseCode = "400",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = uz.pdp.ecommerce.payload.ApiResponse.class))),
        @ApiResponse(responseCode = "401    ",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = uz.pdp.ecommerce.payload.ApiResponse.class)))})
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    description = "Get all the addresses that belong to yourself",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Address.class)))

    })
    @GetMapping
    public ResponseEntity<?> getAllOwnAddress(@Parameter(hidden = true) @CurrentUser User user) {
        List<Address> userAddress = addressService.findUserAddress(user);
        return ResponseEntity.ok(userAddress);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveAddress(@CurrentUser User user) {
        Address address = addressService.findActiveAddress(user.getId());
        return ResponseEntity.ok(address);
    }

    @PostMapping
    public ResponseEntity<?> addAddress(@Valid @RequestBody ReqAddress reqAddress, @CurrentUser User user) {
        CreatedResponse createdResponse = addressService.saveAddress(reqAddress, user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.delete(id));
    }
}