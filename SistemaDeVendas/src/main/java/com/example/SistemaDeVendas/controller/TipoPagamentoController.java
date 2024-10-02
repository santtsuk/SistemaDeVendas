package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.facades.TipoPagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class TipoPagamentoController {
    private TipoPagamentoFacade tipoPagamentoFacade;

    @Autowired
    public TipoPagamentoController(TipoPagamentoFacade tipoPagamentoFacade) {
        this.tipoPagamentoFacade = tipoPagamentoFacade;
    }

    @GetMapping("/buscarTipoPagamento")
    public ResponseEntity<ArrayList<TipoPagamento>> buscarTodos() {
        ArrayList<TipoPagamento> tipoPagamentos = tipoPagamentoFacade.buscarTodos();

        return ResponseEntity.ok(tipoPagamentos);
    }

    @GetMapping("/buscarTipoPagamento/{id}")
    public ResponseEntity<TipoPagamento> buscarPorId(@PathVariable int id) {
        TipoPagamento tipoPagamento = tipoPagamentoFacade.buscarPorId(id);

        return ResponseEntity.ok(tipoPagamento);
    }
}
