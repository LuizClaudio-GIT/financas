package luiz.claudio.financas.entities.expenses;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.User;
@Data // Generate getters and setters
@NoArgsConstructor // Generate constructor without parameters
@Entity(name = "expenses")
public class Expenses {

    @Id//Seta no banco de dados que isto é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estrategia de geração dp id
    private Long id;
    @Column(nullable = false,unique = true)// Esta anotação diz que o campo no banco de dados não pode ser nulo
//    @ManyToOne
    private User user;


}
