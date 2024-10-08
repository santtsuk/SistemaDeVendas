package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.facades.ProdutoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoFacade produtoFacade;

    @Autowired
    public ProdutoController(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> produtos = produtoFacade.buscarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable int id) {
        Produto produto = produtoFacade.buscarPorId(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Produto produto) {
        produtoFacade.salvar(produto);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable int id, @RequestBody Produto produto) {
        produtoFacade.atualizar(id, produto);

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        produtoFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}