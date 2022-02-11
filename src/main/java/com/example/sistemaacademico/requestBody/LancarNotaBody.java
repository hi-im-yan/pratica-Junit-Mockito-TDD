package com.example.sistemaacademico.requestBody;


public class LancarNotaBody{

    private Long provaId;
    private float nota;

    public LancarNotaBody(Long provaId, float nota) {
        this.provaId = provaId;
        this.nota = nota;
    }

    public Long getProvaId() {
        return provaId;
    }

    public void setProvaId(Long provaId) {
        this.provaId = provaId;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}