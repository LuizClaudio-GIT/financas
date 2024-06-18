package luiz.claudio.financas.controller;

import luiz.claudio.financas.entities.dto.UserDTO;
import luiz.claudio.financas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Ele define para o Java que esta classe è um controlador
@RequestMapping("/user")// Ele define a rota do usuario
public class UserController {

    @Autowired// Injeção de dependencias
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody @Validated UserDTO data){
        try {
            return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

