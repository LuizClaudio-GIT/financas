package luiz.claudio.financas.entities.expenses;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.dto.EntriesDTO;
import luiz.claudio.financas.entities.dto.ExpensesDTO;
import luiz.claudio.financas.entities.dto.UserDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("entries")
public class Entries {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    private String name;
    private double amount;
    private User user;
    private LocalDateTime creationDate;


    public Entries(EntriesDTO data) {
        this.id = data.id();
        this.name = data.name();
        this.amount = data.amount();
        this.user = data.user();
        this.creationDate = LocalDateTime.now().minusHours(3);
    }

    public void updateExpenses(EntriesDTO data){
        this.id = data.id();
        this.name = data.name();
        this.amount = data.amount();
        this.user = data.user();
        this.creationDate = LocalDateTime.now().minusHours(3);
    }
}