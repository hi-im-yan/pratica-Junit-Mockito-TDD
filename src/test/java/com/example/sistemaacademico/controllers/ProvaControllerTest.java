package com.example.sistemaacademico.controllers;

import com.example.sistemaacademico.models.Aluno;
import com.example.sistemaacademico.models.Prova;
import com.example.sistemaacademico.models.Turma;
import com.example.sistemaacademico.repositories.ProvaRepository;
import com.example.sistemaacademico.requestBody.LancarNotaRequestBody;
import com.example.sistemaacademico.services.LancamentoNotaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProvaControllerTest {

    private MockMvc mvc;

    @Mock
    private LancamentoNotaService lancamentoNotaService;

    @Mock
    private ProvaRepository provaRepository;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
        ProvaController controller = new ProvaController(lancamentoNotaService);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Enviando Request para /prova/lancarNota")
    public void lancarNota() throws Exception {

        Mockito.when(provaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getProva()));

        MvcResult response = mvc.perform(post("/prova/lancarNota")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectToJson(reqBody())))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(response.getResponse().getContentAsString());
    }

    private LancarNotaRequestBody reqBody(){
        return new LancarNotaRequestBody(1L, 7.8f);
    }

    private Prova getProva(){
        return new Prova(1L);
    }

    private String objectToJson(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}