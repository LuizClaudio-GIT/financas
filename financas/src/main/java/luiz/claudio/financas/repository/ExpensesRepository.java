package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.expenses.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpensesRepository extends MongoRepository<Expenses, String> {

    boolean existsByName(String name);
}
