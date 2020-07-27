package uz.pdp.ecommerce.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Address;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.CreatedResponse;
import uz.pdp.ecommerce.payload.ReqAddress;
import uz.pdp.ecommerce.repository.AddressRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
        System.out.println("********");
        System.out.println("      **\n" +
                "      **\n" +
                "      **");
        System.out.println("**    **\n" +
                "**    **\n" +
                " *******");


    }

    @Override
    public List<Address> findUserAddress(User user) {
        List<Address> address = addressRepository.findAllByCreatedBy(user.getId());
        if (address.size() <= 0) {
            throw new NotFoundException("Sizda hali manzil mavjuda emas. Iltimos manzilni kiriting.");
        }
        return address;

    }

    @Override
    public Address findActiveAddress(UUID id) {
        return addressRepository.findByCreatedByAndActiveTrue(id)
                .orElseThrow(() -> new NotFoundException("Sizda hali manzil mavjuda emas. Iltimos manzilni kiriting."));
    }

    @Override
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

    @Override
    public CreatedResponse delete(UUID id) {
        try {
            addressRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("O`chish uchun mavjud element tanlanmagan.\n " +
                    "Iltimos qaytadan urunib ko`ring." +
                    "\n Yoki qo`llab quvvatlashga murojat qiling.");
        }
        return new CreatedResponse(id.toString(), "Addrees o`chirildi.");
    }
}
