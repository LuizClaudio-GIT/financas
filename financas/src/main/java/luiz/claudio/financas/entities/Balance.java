package luiz.claudio.financas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.entriesAndExits.EntriesAndExits;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Document("balance")
public class Balance {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    private double balance;
    private EntriesAndExits entriesAndExits;

}
