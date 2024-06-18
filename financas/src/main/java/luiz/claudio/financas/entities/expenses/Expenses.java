package luiz.claudio.financas.entities.expenses;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.User;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Generate getters and setters
@NoArgsConstructor // Generate constructor without parameters
@Document("expenses")
public class Expenses {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    @Column(nullable = false,unique = true)// Esta anotação diz que o campo no banco de dados não pode ser nulo
    private User user;
    private Period period;
    private Type expensensType;


}
