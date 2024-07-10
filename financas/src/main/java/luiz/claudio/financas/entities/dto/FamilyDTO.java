package luiz.claudio.financas.entities.dto;

import luiz.claudio.financas.entities.User;

import java.util.List;

public record FamilyDTO(String id,
                        String name,
                        List <User> user,
                        double balance,
                        double expenses,
                        double entries) {
}
