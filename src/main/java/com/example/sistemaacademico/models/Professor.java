package com.example.sistemaacademico.models;

import javax.persistence.*;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculdade_id", nullable = false)
    private Faculdade faculdade;

    private String nome;

    private String email;

    private boolean Substituto;

    public Faculdade getFaculdadeId() {
        return faculdade;
    }

    public void setFaculdadeId(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
