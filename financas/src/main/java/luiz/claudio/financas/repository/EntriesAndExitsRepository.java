package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.entriesAndExits.EntriesAndExits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntriesAndExitsRepository extends JpaRepository<EntriesAndExits, Long> {
}
