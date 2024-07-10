package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.Family;
import luiz.claudio.financas.entities.dto.FamilyDTO;
import luiz.claudio.financas.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {
    @Autowired//
    private FamilyRepository repository;

    public Family create(FamilyDTO data) {
        Family newFamily = new Family(data);
        validate(newFamily);
        repository.save(newFamily);
        return newFamily;
    }

    public void validate(Family family) {
        if (repository.existsByName(family.getName())) {
            throw new DuplicateKeyException("A entrada  já esta registrada neste  usuário");
        }
    }


    public Family update(FamilyDTO data) {
        Family existingFamily = repository.findById(data.id())
                .orElseThrow(() -> new IllegalArgumentException("Entrada não encontrada com o ID: "));
        existingFamily.updateFamily(data);
        repository.save(existingFamily);
        return existingFamily;
    }

    public String delete(String id) {
        if (!repository.existsById(id)) {
            return "Family nao existe";
        }
        repository.existsById(id);
        return "Sucessfull";
    }


    public List<Family> get() {
        return repository.findAll();
    }

    public Optional<Family> getById(String id) {
        return repository.findById(id);
    }


}



