package com.example.sistemaacademico.services;

import com.example.sistemaacademico.models.Aluno;
import com.example.sistemaacademico.models.Turma;
import com.example.sistemaacademico.repositories.GradeSemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    private GradeSemestreRepository gradeSemestreRepository;

    @Autowired
    public MatriculaService(GradeSemestreRepository gradeSemestreRepository) {
        this.gradeSemestreRepository = gradeSemestreRepository;
    }

    public void matricularAlunoEmTurma(long aludoId, long turmaId){

    }
}
