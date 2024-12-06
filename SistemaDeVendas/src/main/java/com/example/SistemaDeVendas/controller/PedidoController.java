package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.facades.PedidoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido/")
public class PedidoController {
    private final PedidoFacade pedidoFacade;

    @Autowired
    public PedidoController(PedidoFacade pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
    }

    @GetMapping ("buscarTodos")
    public ResponseEntity<List<Pedido>> buscarTodos() {
        List<Pedido> pedidos = pedidoFacade.buscarTodos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("buscarPorID/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable int id) {
        Pedido pedido = pedidoFacade.buscarPorId(id);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Pedido pedido) {
        pedidoFacade.salvar(pedido);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable int id, @RequestBody Pedido pedido) {
        pedidoFacade.atualizar(id, pedido);

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        pedidoFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}