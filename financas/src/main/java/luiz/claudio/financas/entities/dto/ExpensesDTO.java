package luiz.claudio.financas.entities.dto;
import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.expenses.Type;

public record ExpensesDTO (String id,
                          String name,
                          double amount,
                          User user,
                          Type expensesType
                          ){
}

