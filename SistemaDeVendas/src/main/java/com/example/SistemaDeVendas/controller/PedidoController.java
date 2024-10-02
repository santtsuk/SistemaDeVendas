package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.facades.PedidoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class PedidoController {
    private PedidoFacade pedidoFacade;

    @Autowired
    public PedidoController(PedidoFacade pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
    }

    @GetMapping("/buscarPedido")
    public ResponseEntity<ArrayList<Pedido>> buscarTodos() {
        ArrayList<Pedido> pedidos = pedidoFacade.buscarTodos();

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/buscarPedido/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable int id) {
        Pedido pedido = pedidoFacade.buscarPorId(id);

        return ResponseEntity.ok(pedido);
    }
}
