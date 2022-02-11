package com.example.sistemaacademico.services;

import com.example.sistemaacademico.models.Aluno;
import com.example.sistemaacademico.models.GradeSemestre;
import com.example.sistemaacademico.models.Turma;
import com.example.sistemaacademico.repositories.AlunoRepository;
import com.example.sistemaacademico.repositories.GradeSemestreRepository;
import com.example.sistemaacademico.repositories.TurmaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MatriculaServiceTest {

    @Mock
    private GradeSemestreRepository gradeSemestreRepository;

    @Mock
    private TurmaRepository turmaRepository;

    @Mock
    private AlunoRepository alunoRepository;

    private MatriculaService matriculaService;

    @BeforeEach
    private void beforeAll(){
        MockitoAnnotations.initMocks(this);
        matriculaService = new MatriculaService(gradeSemestreRepository);
    }

    @Test
    public void deveMatricularAlunoNaTurma(){
        List<Turma> turmas = getTurmas();
        List<Aluno> alunos = getAluno();
        Mockito.when(alunoRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(alunos.get(0)));
        Mockito.when(turmaRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(turmas.get(0)));

        GradeSemestre gradeSemestre = new GradeSemestre(turmas.get(0), alunos.get(0));
        Mockito.verify(gradeSemestreRepository).saveAndFlush(gradeSemestre);
    }

    public List<Turma> getTurmas(){
        List<Turma> turmas = new ArrayList<>();

        Turma turma1 = new Turma();
        Turma turma2 = new Turma();
        Turma turma3 = new Turma();
        Turma turma4 = new Turma();

        turmas.add(turma1);
        turmas.add(turma2);
        turmas.add(turma3);
        turmas.add(turma4);

        return turmas;
    }

    public List<Aluno> getAluno(){
        List<Aluno> alunos = new ArrayList<>();

        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();
        Aluno aluno4 = new Aluno();

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);

        return alunos;
    }

}