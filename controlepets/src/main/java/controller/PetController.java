package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Pet;
import repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired private PetRepository repo;

    @GetMapping public List<Pet> listar() { return repo.findAll(); }

    @PostMapping public Pet criar(@RequestBody Pet p) { return repo.save(p); }

    @PutMapping("/{id}") 
    public Pet atualizar(@PathVariable Long id, @RequestBody Pet novo) {
        novo.setId(id);
        return repo.save(novo);
    }

    @DeleteMapping("/{id}") 
    public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}
