package luiz.claudio.financas.entities.dto;

import luiz.claudio.financas.entities.Address;
import luiz.claudio.financas.entities.Balance;
import luiz.claudio.financas.entities.expenses.Entries;
import luiz.claudio.financas.entities.expenses.Expenses;

public record UserDTO(String id,
                      String username,
                      int age,
                      String document,
                      String email,
                      String password,
                      Address address,
                      Entries entries,
                      Expenses expenses,
                      double balance) {

}
