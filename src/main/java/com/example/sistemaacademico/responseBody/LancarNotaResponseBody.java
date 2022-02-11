package com.example.sistemaacademico.responseBody;

import com.example.sistemaacademico.models.Prova;

public class LancarNotaResponseBody {

    private String message;
    private Prova prova;

    public LancarNotaResponseBody(String message, Prova prova) {
        this.message = message;
        this.prova = prova;
    }

    public LancarNotaResponseBody() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }
}
