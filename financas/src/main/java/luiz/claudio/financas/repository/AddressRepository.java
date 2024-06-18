package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, Long> {

}
