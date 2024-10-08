package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.facades.TipoPagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TipoPagamentoController {
    private final TipoPagamentoFacade tipoPagamentoFacade;

    @Autowired
    public TipoPagamentoController(TipoPagamentoFacade tipoPagamentoFacade) {
        this.tipoPagamentoFacade = tipoPagamentoFacade;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<TipoPagamento>> buscarTodos() {
        List<TipoPagamento> tipoPagamentos = tipoPagamentoFacade.buscarTodos();
        return ResponseEntity.ok(tipoPagamentos);
    }

    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<TipoPagamento> buscarPorId(@PathVariable int id) {
        TipoPagamento tipoPagamento = tipoPagamentoFacade.buscarPorId(id);
        return tipoPagamento != null ? ResponseEntity.ok(tipoPagamento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody TipoPagamento tipoPagamento) {
        tipoPagamentoFacade.salvar(tipoPagamento);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagamento> atualizar(@PathVariable int id, @RequestBody TipoPagamento tipoPagamento) {
        tipoPagamentoFacade.atualizar(id, tipoPagamento);

        return ResponseEntity.ok(tipoPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        tipoPagamentoFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}
