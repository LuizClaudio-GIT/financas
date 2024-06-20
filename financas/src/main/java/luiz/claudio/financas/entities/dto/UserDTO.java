package luiz.claudio.financas.entities.dto;

public record UserDTO(String id,
                      String username,
                      int age,
                      String document,
                      String email,
                      String password) {

}
