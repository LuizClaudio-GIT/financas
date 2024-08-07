package luiz.claudio.financas.controller;

import luiz.claudio.financas.entities.User;
import luiz.claudio.financas.entities.dto.UserDTO;
import luiz.claudio.financas.entities.expenses.Entries;
import luiz.claudio.financas.entities.expenses.Expenses;
import luiz.claudio.financas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Ele define para o Java que esta classe è um controlador
@RequestMapping("/user")// Ele define a rota do usuario
public class UserController {

    @Autowired// Injeção de dependencias
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody @Validated UserDTO data) {
        try {
            return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated UserDTO data) {
        try {
            return new ResponseEntity<>(service.update(data), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser() {
        try {
            List<User> user = service.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-user-entry")
    public ResponseEntity<?> updateUserBalance(@RequestParam String id, @RequestBody Entries entries) {
        try {

            return new ResponseEntity<>(service.updateUserBalanceEntrada(id, entries), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update-user-expense")
    public ResponseEntity<?> updateUserBalance(@RequestParam String id, @RequestBody Expenses expenses) {
        try {

            return new ResponseEntity<>(service.updateUserBalanceSaida(id, expenses), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}






