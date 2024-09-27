package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import com.example.SistemaDeVendas.facades.DescontoFidelidadeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class DescontoFidelidadeController {

    private DescontoFidelidadeFacade descontoFidelidadeFacade;

    public void inicializarProdutos() {
        ClienteFacade clienteFacade = null;
        Cliente cliente = clienteFacade.buscarPorId(1);
        descontoFidelidadeFacade.salvar(1,cliente,10.50f,"30/08/2023");
    }

    @Autowired
    public DescontoFidelidadeController(DescontoFidelidadeFacade descontoFidelidadeFacade) {
        this.descontoFidelidadeFacade = descontoFidelidadeFacade;
        inicializarProdutos();
    }

    @GetMapping("/buscarDescontosFidelidades")
    public ResponseEntity<ArrayList<DescontoFidelidade>> buscarTodos() {
        ArrayList<DescontoFidelidade> descontosFidelidades = descontoFidelidadeFacade.buscarTodos();

        return ResponseEntity.ok(descontosFidelidades);
    }

    @GetMapping("/buscarProduto/{id}")
    public ResponseEntity<DescontoFidelidade> buscarPorId(@PathVariable int id) {
        DescontoFidelidade descontoFidelidade = descontoFidelidadeFacade.buscarPorId(id);

        return ResponseEntity.ok(descontoFidelidade);
    }

}
