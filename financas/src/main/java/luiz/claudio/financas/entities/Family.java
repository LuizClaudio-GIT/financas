package luiz.claudio.financas.entities;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.dto.FamilyDTO;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document("family")
public class Family {

    @Id
    private String id;
    private String name;
    @DBRef
    private List<User> user = new ArrayList<>();
    private double balance;
    private double expenses;
    private double entries;


    public Family(FamilyDTO data){
        this.id = data.id();
        this.name = data.name();
        this.user = data.user();
        this.balance = data.balance();
        this.expenses = data.expenses();
        this.entries = data.entries();
    }

    public void updateFamily(FamilyDTO data){
        this.id = data.id();
        this.name = data.name();
        this.user = data.user();
        this.balance = data.balance();
        this.expenses = data.expenses();
        this.entries = data.entries();
    }

    public void addBalanceUser(List<User> users) {
        if (users != null && !users.isEmpty()) {
            double totalBalance = users.stream()
                    .mapToDouble(User::getBalance)
                    .sum();
            addBalanceFamily(totalBalance);
        }
    }


    private void addBalanceFamily(double totalBalance) {
        System.out.println("Saldo total adicionado à família: " + totalBalance);
    }


}
