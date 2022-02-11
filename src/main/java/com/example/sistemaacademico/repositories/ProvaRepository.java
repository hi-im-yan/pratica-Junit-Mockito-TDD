package com.example.sistemaacademico.repositories;

import com.example.sistemaacademico.models.Prova;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaRepository extends JpaRepository<Prova, Long> {
}