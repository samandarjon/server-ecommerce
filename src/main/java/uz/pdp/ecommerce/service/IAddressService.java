package uz.pdp.ecommerce.service;

import uz.pdp.ecommerce.entity.Address;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.CreatedResponse;
import uz.pdp.ecommerce.payload.ReqAddress;

import java.util.List;
import java.util.UUID;

public interface IAddressService {

    List<Address> findUserAddress(User user);

    Address findActiveAddress(UUID id);

    CreatedResponse saveAddress(ReqAddress reqAddress, UUID id);

    CreatedResponse delete(UUID id);
}
