package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.ProdutoApplication;
import com.example.SistemaDeVendas.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProdutoFacade {

    private ProdutoApplication produtoApplication;

    public ProdutoFacade(ProdutoApplication produtoApplication) {
        this.produtoApplication = produtoApplication;
    }

    public Produto buscarPorId(int id) {
        return this.produtoApplication.buscarPorId(id);
    }

    public List<Produto> buscarTodos() {
        return this.produtoApplication.buscarTodos();
    }

    public Produto salvar(Produto produto) {
        produtoApplication.salvar(produto);
        return produto;
    }

    public void atualizar(int id, Produto produtoAtualizado) {
        this.produtoApplication.atualizar(id, produtoAtualizado);
    }

    public void deletar(int id) {
        this.produtoApplication.deletar(id);
    }
}