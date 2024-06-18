package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.entriesAndExits.EntriesAndExits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntriesAndExitsRepository extends MongoRepository<EntriesAndExits, Long> {
}
