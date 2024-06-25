package luiz.claudio.financas.entities.dto;

import luiz.claudio.financas.entities.entriesAndExits.Type;

import java.time.LocalDate;

public record EntriesAndExitsDTO(String id,
                                 LocalDate date,
                                 Type type) {
}
