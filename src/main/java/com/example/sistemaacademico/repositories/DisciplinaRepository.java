package com.example.sistemaacademico.repositories;

import com.example.sistemaacademico.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}