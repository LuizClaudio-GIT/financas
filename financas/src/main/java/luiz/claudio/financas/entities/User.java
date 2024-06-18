package luiz.claudio.financas.entities;

import jakarta.persistence.*;
import lombok.*;
import luiz.claudio.financas.entities.dto.UserDTO;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Document("user")
public class User implements Serializable { // Serializable é utilizada para permitir a serialização de uma classe,processo de converter um objeto em um fluxo de bytes para que ele possa ser facilmente salvo em um arquivo ou transmitido por uma rede

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    @Indexed(unique = true)// Indica que a variavel n pode ser repetida pelos usuários
    @Field("user_name")
    private String userName;
    @Indexed(unique = true)
    @Field("age") // indica o nome que eu quero  que seja registrado no banco de dados, esta anotação é utilizada para bancos NoSQL
    private int age;
    @Indexed(unique = true)
    @Field("document")// indica o nome que eu quero  que seja registrado no banco de dados, esta anotação é utilizada para bancos NoSQL
    private String document;
    @Indexed(unique = true)
    @Field("email")// indica o nome que eu quero  que seja registrado no banco de dados, esta anotação é utilizada para bancos NoSQL
    private String email;
    @Indexed(unique = true)
    @Field("password")// indica o nome que eu quero  que seja registrado no banco de dados, esta anotação é utilizada para bancos NoSQL
    private String password;
    @Indexed(unique = true)
    @Field("data_criacao")// indica o nome que eu quero  que seja registrado no banco de dados, esta anotação é utilizada para bancos NoSQL
    private LocalDateTime dataCriacao; // Registra a data e a hora da inserção de um usuário  no banco
    @Indexed(unique = true)
    @Field("data_modificacao")// indica o nome que eu quero  que seja registrado no banco de dados, esta anotação é utilizada para bancos NoSQL
    private LocalDateTime dataModificacao;// Registra quando o cadastro dos usuarios sofrem um update



    public User(UserDTO data) {
        this.id = data.id();
        this.userName = data.userName();
        this.age = data.age();
        this.document = data.document();
        this.email = data.email();
    }
}