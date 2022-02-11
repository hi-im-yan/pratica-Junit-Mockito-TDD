package com.example.sistemaacademico.services;

import com.example.sistemaacademico.models.Aluno;
import com.example.sistemaacademico.models.Prova;
import com.example.sistemaacademico.models.Turma;
import com.example.sistemaacademico.repositories.AlunoRepository;
import com.example.sistemaacademico.repositories.GradeSemestreRepository;
import com.example.sistemaacademico.repositories.ProvaRepository;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LancamentoNotaServiceTest {

    @Mock
    AlunoRepository alunoRepository;

    @Mock
    ProvaRepository provaRepository;

    @Mock
    GradeSemestreRepository gradeSemestreRepository;

    private LancamentoNotaService service;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
        this.service = new LancamentoNotaService(provaRepository);
    }

    @Test
    @DisplayName("Caso salvar nota válida")
    public void deveSalvarNotaEmUmaProva(){
        /*
        * Verifica se o método saveAndFlush foi usado
        * Verifica nota salva é igual ao que foi enviado no parametro
        * */

        List<Prova> provas = getProvas();
        Mockito.when(provaRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(provas.get(0)));
        service.lancarNotaNaProva(1L, 7.8f);

        Prova provaTeste = provas.get(0);
        Mockito.verify(provaRepository).saveAndFlush(Mockito.any(Prova.class));
        assertEquals(7.8f, provaTeste.getNota());
    }

    @Test
    @DisplayName("Caso nota negativa")
    public void naoDeveSalvarNotaEmUmaProvaCasoNotaSejaNegativo(){
        /*
        * Verifica se a nota não foi salva
        * Verifica se houve uma RuntimeException
        * */

        List<Prova> provas = getProvas();
        Mockito.when(provaRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(provas.get(0)));

        try{
            service.lancarNotaNaProva(1L, -7.8f);
            Exception exception = assertThrows(RuntimeException.class, ()->service.lancarNotaNaProva(1L, -7.8f));
            Mockito.verify(provaRepository, Mockito.never()).saveAndFlush(Mockito.any(Prova.class));
            assertEquals("Nota inválida", exception.getMessage());
        }
        catch(Exception e){}
    }

    @Test
    @DisplayName("Caso nota maior que 10")
    public void naoDeveSalvarNotaEmUmaProvaCasoNotaSejaMaiorQue10(){
        /*
         * Verifica se a nota não foi salva
         * Verifica se houve uma RuntimeException
         * */

        List<Prova> provas = getProvas();
        Mockito.when(provaRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(provas.get(0)));

        try{
            service.lancarNotaNaProva(1L, 15.5f);
            Exception exception = assertThrows(RuntimeException.class, ()->service.lancarNotaNaProva(1L, -7.8f));
            Mockito.verify(provaRepository, Mockito.never()).saveAndFlush(Mockito.any(Prova.class));
            assertEquals("Nota inválida", exception.getMessage());
        }
        catch(Exception e){}
    }

    private List<Prova> getProvas(){
        List<Prova> listaProvas = new ArrayList<>();

        Prova prova1 = new Prova(1L);
        Prova prova2 = new Prova(2L);
        Prova prova3 = new Prova(3L);
        Prova prova4 = new Prova(4L);

        listaProvas.add(prova1);
        listaProvas.add(prova2);
        listaProvas.add(prova3);
        listaProvas.add(prova4);

        return listaProvas;
    }
}