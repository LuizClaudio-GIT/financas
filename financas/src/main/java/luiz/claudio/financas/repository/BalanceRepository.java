package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.Address;
import luiz.claudio.financas.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BalanceRepository extends MongoRepository<Balance, Long> {
}
