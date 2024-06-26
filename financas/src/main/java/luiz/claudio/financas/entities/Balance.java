package luiz.claudio.financas.entities;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Document("balance")
public class Balance {



    private double balance;
}
