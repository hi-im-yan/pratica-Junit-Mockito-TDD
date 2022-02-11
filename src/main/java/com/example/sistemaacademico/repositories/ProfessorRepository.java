package com.example.sistemaacademico.repositories;

import com.example.sistemaacademico.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}