package com.example.sistemaacademico.models;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    Professor professor;

    private String nome;

    private LocalTime horarioInicial;

    private LocalTime horarioFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disciplina getDisciplinaId() {
        return disciplina;
    }

    public void setDisciplinaId(Disciplina disciplinaId) {
        this.disciplina = disciplina;
    }

    public Professor getProfessorId() {
        return professor;
    }

    public void setProfessorId(Professor professorId) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
}
