package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.Address;
import luiz.claudio.financas.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository <Balance, Long> {
}
