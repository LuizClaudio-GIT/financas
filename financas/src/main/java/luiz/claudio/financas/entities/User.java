package luiz.claudio.financas.entities;

import jakarta.persistence.*;
import lombok.*;
import luiz.claudio.financas.entities.dto.UserDTO;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Entity(name = "user")
public class User {

    @Id//Seta no banco de dados que isto é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estrategia de geração dp id
    private Long id;
    @Column(nullable = false, unique = true)// Esta anotação diz que o campo no banco de dados não pode ser nulo
    private String userName;
    private int age;
    @Column(nullable = false,unique = true)// Esta anotação diz que o campo no banco de dados não pode ser nulo
    private String document;
    @Column(nullable = false,unique = true)// Esta anotação diz que o campo no banco de dados não pode ser nulo
    private String email;

    public User(UserDTO data) {
        this.id = data.id();
        this.userName = data.userName();
        this.age = data.age();
        this.document = data.document();
        this.email = data.email();
    }
}