package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Address;
import restorder.orderproduk.repositories.AddressesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressesRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address getById(Long addressId) {
        return getById(addressId, true);
    }

    private Address getById(Long addressId, boolean throwIfDoesnotExist) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (!address.isPresent() && throwIfDoesnotExist)
            throw new ResourceNotFoundException();

        return address.orElse(null);
    }

    public List<Address> fetchByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}

