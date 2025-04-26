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

import model.Agendamento;
import repository.AgendamentoRepository;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired private AgendamentoRepository repo;

    @GetMapping public List<Agendamento> listar() { return repo.findAll(); }

    @PostMapping public Agendamento criar(@RequestBody Agendamento ag) { return repo.save(ag); }

    @PutMapping("/{id}") 
    public Agendamento atualizar(@PathVariable Long id, @RequestBody Agendamento novo) {
        novo.setId(id);
        return repo.save(novo);
    }

    @DeleteMapping("/{id}") 
    public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}
