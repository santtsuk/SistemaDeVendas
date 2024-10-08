package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.facades.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class PagamentoController {
    private final PagamentoFacade pagamentoFacade;

    @Autowired
    public PagamentoController(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @GetMapping("/buscarPagamento")
    public ResponseEntity<List<Pagamento>> buscarTodos() {
        List<Pagamento> pagamento = pagamentoFacade.buscarTodos();

        return ResponseEntity.ok(pagamento);
    }

    @GetMapping("/buscarPagamento/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable int id) {
        Pagamento pagamento = pagamentoFacade.buscarPorId(id);

        return pagamento != null ? ResponseEntity.ok(pagamento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Pagamento pagamento) {
        pagamentoFacade.salvar(pagamento);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable int id, @RequestBody Pagamento pagamento) {
        pagamentoFacade.atualizar(id, pagamento);

        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        pagamentoFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}