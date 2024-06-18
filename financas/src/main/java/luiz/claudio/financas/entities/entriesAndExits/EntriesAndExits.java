package luiz.claudio.financas.entities.entriesAndExits;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Entity(name = "entriesandexits")
public class EntriesAndExits {

    @Id//Seta no banco de dados que isto é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estrategia de geração dp id
    private Long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Type type;
}
