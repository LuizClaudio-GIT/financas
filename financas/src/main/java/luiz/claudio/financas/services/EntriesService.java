package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.Address;
import luiz.claudio.financas.entities.dto.EntriesDTO;
import luiz.claudio.financas.entities.expenses.Entries;
import luiz.claudio.financas.repository.EntriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntriesService {

    @Autowired
    public EntriesRepository repository;


    public Entries save(Entries entries){
        if (entries == null){
            return null;
        }

        return repository.save(entries);
    }



    public Entries create(EntriesDTO data) {
        Entries newEntries = new Entries(data);
        validate(newEntries);
        repository.save(newEntries);
        return newEntries;
    }

    public void validate(Entries entries) {
        if (repository.existsByName(entries.getName())) {
            throw new DuplicateKeyException("A entrada  já esta registrada neste  usuário");
        }
    }

    public  Entries update(EntriesDTO data) {
        Entries existingEntries =  repository.findById(data.id())
                .orElseThrow(() -> new IllegalArgumentException("Entrada não encontrada com o ID: " ));
        
        repository.save(existingEntries);
        return existingEntries;
    }

    public String delete(String id){
        if(!repository.existsById(id)){
            return "Entrada nao existe";
        }
        repository.existsById(id);
        return "Sucessfull";
    }

    public List<Entries> get(){
        return repository.findAll();
    }

}
