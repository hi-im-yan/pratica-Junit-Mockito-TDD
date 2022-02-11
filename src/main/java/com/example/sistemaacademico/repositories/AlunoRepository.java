package com.example.sistemaacademico.repositories;

import com.example.sistemaacademico.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}