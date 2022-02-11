package com.example.sistemaacademico.requestBody;


public class LancarNotaRequestBody{

    private Long provaId;
    private float nota;

    public LancarNotaRequestBody(Long provaId, float nota) {
        this.provaId = provaId;
        this.nota = nota;
    }

    public LancarNotaRequestBody() {
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