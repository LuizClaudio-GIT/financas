package luiz.claudio.financas.entities.dto;

import luiz.claudio.financas.entities.Address;
import luiz.claudio.financas.entities.Balance;

public record UserDTO(String id,
                      String username,
                      int age,
                      String document,
                      String email,
                      String password,
                      Address address,
                      double balance) {

}
