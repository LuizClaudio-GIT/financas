package luiz.claudio.financas.repository;

import luiz.claudio.financas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
