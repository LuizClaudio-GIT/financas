package luiz.claudio.financas.controller;
import luiz.claudio.financas.entities.expenses.Entries;
import luiz.claudio.financas.services.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import luiz.claudio.financas.entities.dto.EntriesDTO;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntriesController {

    @Autowired
    public EntriesService service;


    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody @Validated EntriesDTO data) {
        try {
            return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated EntriesDTO data) {
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

    @GetMapping
   public ResponseEntity<?> getAllEntries(){
        try {
            List<Entries> entries = service.get();
            return new ResponseEntity<>(entries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
