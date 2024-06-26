package luiz.claudio.financas.entities.expenses;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.dto.ExpensesDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data // Generate getters and setters
@NoArgsConstructor // Generate constructor without parameters
@Document("expenses")
public class Expenses {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    private String name;
    private double amount;
    private User user;
    private Type expensensType;
    private LocalDateTime creationDate;



    public Expenses (ExpensesDTO data){
        this.id = data.id();
        this.name = data.name();
        this.amount = data.amount();
        this.user = data.user();
        this.expensensType = data.expensesType();
        this.creationDate = LocalDateTime.now().minusHours(3);

    }

    public void updateExpenses(ExpensesDTO data){
        this.id = data.id();
        this.name = data.name();
        this.amount = data.amount();
        this.user = data.user();
        this.expensensType = data.expensesType();
        this.creationDate = LocalDateTime.now().minusHours(3);
    }


}
