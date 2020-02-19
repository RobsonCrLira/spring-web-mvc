package br.com.dio.springwebmvc.rest;

import br.com.dio.springwebmvc.exception.JediNotFoundException;
import br.com.dio.springwebmvc.model.Jedi;
import br.com.dio.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){

        return repository.findAll();

    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") long id){
        final Optional<Jedi> jedi = repository.findById(id);

        if (jedi.isPresent()){
            return ResponseEntity.ok(jedi.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }

}
