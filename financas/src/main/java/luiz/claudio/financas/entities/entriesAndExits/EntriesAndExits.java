package luiz.claudio.financas.entities.entriesAndExits;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import luiz.claudio.financas.entities.dto.EntriesAndExitsDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data //Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Document("entries_and_exits")
public class EntriesAndExits {

    @Id//Seta no banco de dados que isto é um ID
    private String id;
    private LocalDate date;
    private Type type;



    public EntriesAndExits (EntriesAndExitsDTO data){
        this.id = data.id();
        this.date = data.date();
        this.type = data.type();
    }

}
