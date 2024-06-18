package luiz.claudio.financas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Document("address")
public class Address {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    private String city;
    private String street;
    private String number;
    private String complement;
}
