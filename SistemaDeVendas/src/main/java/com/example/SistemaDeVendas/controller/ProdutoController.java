package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.facades.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class ProdutoController {
    private ProdutoFacade produtoFacade;

    @Autowired
    public ProdutoController(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }

    @GetMapping("/buscarPedido")
    public ResponseEntity<ArrayList<Produto>> buscarTodos() {
        ArrayList<Produto> produtos = produtoFacade.buscarTodos();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/buscarPedido/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable int id) {
        Produto produto = produtoFacade.buscarPorId(id);

        return ResponseEntity.ok(produto);
    }
}
