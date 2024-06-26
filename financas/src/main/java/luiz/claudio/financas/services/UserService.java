package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.dto.UserDTO;
import luiz.claudio.financas.entities.expenses.Expenses;
import luiz.claudio.financas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Seta que isto é um serviço
public class UserService {

    @Autowired//
    private UserRepository repository;
    @Autowired
    private AddressService addressService;

    public User create(UserDTO data) {
        User newUser = new User(data);
        validate(newUser);
        addressService.save(newUser.getAddress());
        repository.save(newUser);
        return newUser;
    }

    public User update(UserDTO data) {
        User existingUser = repository.findById(data.id())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: "));
        existingUser.updateUser(data);
        validate(existingUser);
        repository.save(existingUser);
        return existingUser;
    }

    public void validate(User user) {
        if (repository.existsByDocument(user.getDocument())) {
            throw new DuplicateKeyException("O documento já esta registrado em outro usuário");
        }
        if (repository.existsByUsername(user.getUsername())) {
            throw new DuplicateKeyException("O nome já esta registrado em outro usuário");
        }
    }

   public String delete(String id) {
       if (!repository.existsById(id)) {
           return "Usuario nao existe";
       }
       repository.deleteById(id);
       return "Sucessfull";
   }

    public List<User> get(){
        return repository.findAll();
    }

    public User updateUserBalance(String id, Expenses expenses, boolean sum){
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: "));
        existingUser.updateUserBalance(expenses, sum);
        repository.save(existingUser);
        return existingUser;

    }


}
