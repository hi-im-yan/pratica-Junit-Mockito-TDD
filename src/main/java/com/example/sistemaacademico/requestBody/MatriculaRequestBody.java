package com.example.sistemaacademico.requestBody;

public class MatriculaRequestBody {

    private long turmaId;
    private long alunoId;

    public MatriculaRequestBody(long turmaId, long alunoId) {
        this.turmaId = turmaId;
        this.alunoId = alunoId;
    }

    public MatriculaRequestBody() {
    }

    public long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(long turmaId) {
        this.turmaId = turmaId;
    }

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }
}
