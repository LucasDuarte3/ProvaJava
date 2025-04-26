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

import model.Proprietario;
import repository.ProprietarioRepository;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }

    @PostMapping
    public Proprietario criar(@RequestBody Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @PutMapping("/{id}")
    public Proprietario atualizar(@PathVariable Long id, @RequestBody Proprietario novo) {
        novo.setId(id);
        return proprietarioRepository.save(novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        proprietarioRepository.deleteById(id);
    }
}
