package com.example.sistemaacademico.models;

import javax.persistence.*;

@Entity
public class GradeSemestre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    private float nota;

    private String status;

    public GradeSemestre(Long id, Turma turma, Aluno alunoId, float nota, String status) {
        this.id = id;
        this.turma = turma;
        this.aluno = aluno;
        this.nota = nota;
        this.status = status;
    }

    public GradeSemestre(long id, Turma turma) {
        this.id = id;
        this.turma = turma;
    }

    public GradeSemestre(Turma turma, Aluno aluno) {
        this.turma = turma;
        this.aluno = aluno;
    }

    public Turma getTurmaId() {
        return turma;
    }

    public void setTurmaId(Turma turmaId) {
        this.turma = turma;
    }

    public Aluno getAlunoId() {
        return aluno;
    }

    public void setAlunoId(Aluno alunoId) {
        this.aluno = aluno;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
