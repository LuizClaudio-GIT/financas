package luiz.claudio.financas.controller;
import luiz.claudio.financas.entities.Family;
import luiz.claudio.financas.entities.dto.FamilyDTO;
import luiz.claudio.financas.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/family")
public class FamilyController {


    @Autowired
    private FamilyService service;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody @Validated FamilyDTO data) {
        try {
            return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated FamilyDTO data) {
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
    public ResponseEntity<?> getAllFamily() {
        try {
            List<Family> family = service.get();
            return new ResponseEntity<>(family, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getFindFamily(@PathVariable String id) {
        try {
            Optional<Family> family = service.getById(id);
            if (family.isPresent()) {
                return new ResponseEntity<>(family.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
