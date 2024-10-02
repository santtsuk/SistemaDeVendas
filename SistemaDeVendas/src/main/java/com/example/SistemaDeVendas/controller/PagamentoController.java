package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.facades.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class PagamentoController {
    private PagamentoFacade pagamentoFacade;

    @Autowired
    public PagamentoController(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @GetMapping("/buscarPagamento")
    public ResponseEntity<ArrayList<Pagamento>> buscarTodos() {
        ArrayList<Pagamento> pagamento = pagamentoFacade.buscarTodos();

        return ResponseEntity.ok(pagamento);
    }

    @GetMapping("/buscarPagamento/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable int id) {
        Pagamento pagamento = pagamentoFacade.buscarPorId(id);

        return ResponseEntity.ok(pagamento);
    }
}
