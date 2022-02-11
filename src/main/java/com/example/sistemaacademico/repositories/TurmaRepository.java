package com.example.sistemaacademico.repositories;

import com.example.sistemaacademico.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}