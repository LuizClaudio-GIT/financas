package luiz.claudio.financas.entities.dto;

public record UserDTO(Long id,
                      String userName,
                      int age,
                      String document,
                      String email) {

}
