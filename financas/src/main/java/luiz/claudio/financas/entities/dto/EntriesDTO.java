package luiz.claudio.financas.entities.dto;

import luiz.claudio.financas.entities.User;

public record EntriesDTO (String id,
                         String name,
                         double amount,
                         User user){
}
