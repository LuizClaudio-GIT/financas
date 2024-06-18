package luiz.claudio.financas.entities.entriesAndExits;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data //Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Document("entries_and_exits")
public class EntriesAndExits {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Type type;
}
