package br.com.dio.springwebmvc.rest;

import br.com.dio.springwebmvc.model.Jedi;
import br.com.dio.springwebmvc.repository.JediRepository;
import br.com.dio.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){

        return service.findAll();

    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") long id){
        final Jedi jedi = service.findById(id);

        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){
        return service.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Object> updateJedi(@PathVariable("id") long id, @Valid @RequestBody Jedi dto){
        final Jedi jedi = service.update(id,dto);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

}