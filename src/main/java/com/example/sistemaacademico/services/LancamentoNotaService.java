package com.example.sistemaacademico.services;

import com.example.sistemaacademico.models.Aluno;
import com.example.sistemaacademico.models.GradeSemestre;
import com.example.sistemaacademico.models.Prova;
import com.example.sistemaacademico.repositories.AlunoRepository;
import com.example.sistemaacademico.repositories.GradeSemestreRepository;
import com.example.sistemaacademico.repositories.ProvaRepository;
import com.example.sistemaacademico.responseBody.LancarNotaResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoNotaService {

    private ProvaRepository provaRepository;
    private AlunoRepository alunoRepository;
    private GradeSemestreRepository gradeSemestreRepository;

    @Autowired
    public LancamentoNotaService(ProvaRepository provaRepository) {
        this.provaRepository = provaRepository;
    }

    public LancarNotaResponseBody lancarNotaNaProva(long provaId, float nota){
        Optional<Prova> optProva = provaRepository.findById(provaId);
        Prova prova = optProva.get();

        if(nota < 0 || nota > 10)
            throw new RuntimeException("Nota negativa inválida");
        else{

            prova.setNota(nota);
            provaRepository.saveAndFlush(prova);
        }

        return new LancarNotaResponseBody("ok", prova);
    }
}
