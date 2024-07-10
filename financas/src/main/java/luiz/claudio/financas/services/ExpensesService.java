package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.dto.ExpensesDTO;
import luiz.claudio.financas.entities.expenses.Entries;
import luiz.claudio.financas.entities.expenses.Expenses;
import luiz.claudio.financas.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    @Autowired
    public ExpensesRepository repository;

    public Expenses save(Expenses expenses){
        if (expenses == null){
            return null;
        }

        return repository.save(expenses);
    }


    public Expenses create(ExpensesDTO data) {
        Expenses newExpenses = new Expenses(data);
        validate(newExpenses);
        repository.save(newExpenses);
        return newExpenses;
    }

    public void validate(Expenses expenses) {
        if (repository.existsByName(expenses.getName())) {
            throw new DuplicateKeyException("A despesa  já esta registrada neste  usuário");
        }
    }

    public  Expenses update(ExpensesDTO data){
        Expenses exstingExpenses = repository.findById(data.id())
                .orElseThrow(() -> new IllegalArgumentException("Despesa não encontrada com o ID: "));
        validate(exstingExpenses);
        repository.save(exstingExpenses);
        return exstingExpenses;
    }

    public String delete(String id){
        if(!repository.existsById(id)){
            return "Despesa nao existe";
        }
        repository.existsById(id);
        return "Sucessfull";
    }

    public List<Expenses> get(){
        return repository.findAll();
    }





}
