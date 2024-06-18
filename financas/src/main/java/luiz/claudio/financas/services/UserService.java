package luiz.claudio.financas.services;

import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.dto.UserDTO;
import luiz.claudio.financas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Seta que isto é um serviço
public class UserService {

    @Autowired//
    private UserRepository repository;

    public User create(UserDTO data){
        User newUser = new User(data);
        repository.save(newUser);
        return newUser;
    }
}
