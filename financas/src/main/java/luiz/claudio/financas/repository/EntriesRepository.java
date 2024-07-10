package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.expenses.Entries;
import luiz.claudio.financas.entities.expenses.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntriesRepository extends MongoRepository<Entries, String> {

    boolean existsByName(String name);
}
