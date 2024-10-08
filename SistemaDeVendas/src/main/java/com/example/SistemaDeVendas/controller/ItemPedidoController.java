package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.facades.ItemPedidoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ItemPedidoController {
    private final ItemPedidoFacade itemPedidoFacade;

    @Autowired
    public ItemPedidoController(ItemPedidoFacade itemPedidoFacade) {
        this.itemPedidoFacade = itemPedidoFacade;
    }

    @GetMapping("/buscarItemPedido/{id}")
    public ResponseEntity<ItemPedido> buscarPorId(@PathVariable int id) {
        ItemPedido itemPedido = itemPedidoFacade.buscarPorId(id);
        return itemPedido != null ? ResponseEntity.ok(itemPedido) : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarItemPedido")
    public ResponseEntity<List<ItemPedido>> buscarTodos() {
        List<ItemPedido> itemPedido = itemPedidoFacade.buscarTodos();
        return ResponseEntity.ok(itemPedido);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ItemPedido itemPedido) {
        itemPedidoFacade.salvar(itemPedido);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizar(@PathVariable int id, @RequestBody ItemPedido itemPedido) {
        itemPedidoFacade.atualizar(id, itemPedido);

        return ResponseEntity.ok(itemPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        itemPedidoFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}