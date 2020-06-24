package uz.pdp.ecommerce.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Address;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.exceprions.NotFoundException;
import uz.pdp.ecommerce.payload.CreatedResponse;
import uz.pdp.ecommerce.payload.ReqAddress;
import uz.pdp.ecommerce.repository.AddressRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public List<Address> findUserAddress(User user) {
        List<Address> address = addressRepository.findAllByCreatedBy(user.getId());
        if (address.size() <= 0) {
            throw new NotFoundException("Sizda hali manzil mavjuda emas. Iltimos manzilni kiriting.");
        }
        return address;

    }

    public Address findActiveAddress(UUID id) {
        return addressRepository.findByCreatedByAndActive(id, true)
                .orElseThrow(() -> new NotFoundException("Sizda hali manzil mavjuda emas. Iltimos manzilni kiriting."));
    }

    public CreatedResponse saveAddress(ReqAddress reqAddress, UUID id) {
        Address address = modelMapper.map(reqAddress, Address.class);
        if (reqAddress.isActive()) {
            List<Address> allByCreatedBy = addressRepository.findAllByCreatedBy(id);
            allByCreatedBy.forEach(address1 -> address1.setActive(false));
            addressRepository.saveAll(allByCreatedBy);
        }

        Address save = addressRepository.save(address);
        return new CreatedResponse(save.getId().toString(), "Address muvoffaqiyatli qo`shildi.");
    }
}
