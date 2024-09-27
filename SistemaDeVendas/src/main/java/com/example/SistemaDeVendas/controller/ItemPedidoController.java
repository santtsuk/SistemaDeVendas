package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.facades.ItemPedidoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class ItemPedidoController {
    private ItemPedidoFacade itemPedidoFacade;

    public void inicializarProdutos() {
        itemPedidoFacade.salvar(1,"auxiliar Administrativo",1412);
    }

    @Autowired
    public ItemPedidoController(ItemPedidoFacade itemPedidoFacade) {
        this.itemPedidoFacade = itemPedidoFacade;
        inicializarProdutos();
    }

    @GetMapping("/buscarItemPedido")
    public ResponseEntity<ArrayList<ItemPedido>> buscarTodos() {
        ArrayList<ItemPedido> itemPedido = itemPedidoFacade.buscarTodos();

        return ResponseEntity.ok(itemPedido);
    }

    @GetMapping("/buscarItemPedido/{id}")
    public ResponseEntity<ItemPedido> buscarPorId(@PathVariable int id) {
        ItemPedido itemPedido = itemPedidoFacade.buscarPorId(id);

        return ResponseEntity.ok(itemPedido);
    }
}
