package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}
