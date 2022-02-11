package com.example.sistemaacademico.controllers;

import com.example.sistemaacademico.requestBody.LancarNotaBody;
import com.example.sistemaacademico.services.LancamentoNotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prova")
public class ProvaController {


    private final LancamentoNotaService lancamentoNotaService;

    @Autowired
    public ProvaController(LancamentoNotaService lancamentoNotaService) {
        this.lancamentoNotaService = lancamentoNotaService;
    }


    @PostMapping("/lancarNota")
    public void lancarNota(@RequestBody LancarNotaBody reqBody){
        lancamentoNotaService.lancarNotaNaProva(reqBody.getProvaId(), reqBody.getNota());
    }
}
