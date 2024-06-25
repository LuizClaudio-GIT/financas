package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.dto.EntriesAndExitsDTO;
import luiz.claudio.financas.entities.entriesAndExits.EntriesAndExits;
import luiz.claudio.financas.entities.entriesAndExits.Type;
import luiz.claudio.financas.repository.EntriesAndExitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class EntriesAndExitsService {

    @Autowired
    private EntriesAndExitsRepository repository;

    public EntriesAndExits create(EntriesAndExitsDTO data) {
        EntriesAndExits newEntriesAndExits = new EntriesAndExits(data);
        validate(newEntriesAndExits);
        repository.save(newEntriesAndExits);
        return newEntriesAndExits;

    }

    public void validate(EntriesAndExits entriesAndExits) {
        if (entriesAndExits.getType() == Type.ENTRY) {
            if (repository.existsByIdAndType(entriesAndExits.getId(), Type.ENTRY)) {
                throw new DuplicateKeyException("Entratda  ja registrada");
            }

        } else if (entriesAndExits.getType() == Type.EXIT) {
            if (repository.existsByIdAndType(entriesAndExits.getId(), Type.EXIT)) {
                throw new DuplicateKeyException("Saida  ja registrada");
            }


        }

    }


}
