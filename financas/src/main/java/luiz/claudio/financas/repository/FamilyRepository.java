package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository <Family, String> {

    boolean existsByName(String name);
}
