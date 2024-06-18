package luiz.claudio.financas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generate getters and setters
@NoArgsConstructor //Generate constructor without parameters
@Entity(name = "address")
public class Address {

    @Id//Seta no banco de dados que isto é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estrategia de geração dp id
    private Long id;
    private String city;
    private String street;
    private  String number;
    private String complement;
}
