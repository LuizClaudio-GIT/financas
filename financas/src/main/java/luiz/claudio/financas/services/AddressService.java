package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.Address;
import luiz.claudio.financas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    public AddressRepository repository;

    public Address save( Address address){
        if (address == null){
            return null;
        }

        return repository.save(address);
    }

}
