package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.entity.Address;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.CreatedResponse;
import uz.pdp.ecommerce.payload.ReqAddress;
import uz.pdp.ecommerce.security.CurrentUser;
import uz.pdp.ecommerce.service.AddressService;

import java.util.List;
import java.util.UUID;

@RestController("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOwnAddress(@CurrentUser User user) {
        List<Address> userAddress = addressService.findUserAddress(user);
        return ResponseEntity.ok(userAddress);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveAddress(@CurrentUser User user) {
        Address address = addressService.findActiveAddress(user.getId());
        return ResponseEntity.ok(address);
    }

    @PostMapping
    public ResponseEntity<?> addAddress(@RequestBody ReqAddress reqAddress, @CurrentUser User user) {
        CreatedResponse createdResponse = addressService.saveAddress(reqAddress, user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.delete(id));
    }
}