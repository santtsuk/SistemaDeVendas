package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import com.example.SistemaDeVendas.facades.DescontoFidelidadeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class DescontoFidelidadeController {

    private DescontoFidelidadeFacade descontoFidelidadeFacade;

    @Autowired
    public DescontoFidelidadeController(DescontoFidelidadeFacade descontoFidelidadeFacade) {
        this.descontoFidelidadeFacade = descontoFidelidadeFacade;
    }

    @GetMapping("/buscarDescontosFidelidades")
    public ResponseEntity<List<DescontoFidelidade>> buscarTodos() {
        List<DescontoFidelidade> descontosFidelidades = descontoFidelidadeFacade.buscarTodos();

        return ResponseEntity.ok(descontosFidelidades);
    }

    @GetMapping("/buscarDescontoFidelidade/{id}")
    public ResponseEntity<DescontoFidelidade> buscarPorId(@PathVariable int id) {
        DescontoFidelidade descontoFidelidade = descontoFidelidadeFacade.buscarPorId(id);

        return ResponseEntity.ok(descontoFidelidade);
    }

}
