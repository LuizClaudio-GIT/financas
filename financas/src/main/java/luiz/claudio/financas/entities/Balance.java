package luiz.claudio.financas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.entriesAndExits.EntriesAndExits;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Entity(name = "balance")
public class Balance {

    @Id//Seta no banco de dados que isto é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estrategia de geração dp id
    private Long id;
    private double balance;
    private EntriesAndExits entriesAndExits;

}
