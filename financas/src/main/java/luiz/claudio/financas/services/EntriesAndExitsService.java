package luiz.claudio.financas.services;

import luiz.claudio.financas.repository.EntriesAndExitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntriesAndExitsService {

    @Autowired
    private EntriesAndExitsRepository repository;


}
