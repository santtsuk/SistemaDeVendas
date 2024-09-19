package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.ProdutoApplication;
import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPedido;
import com.example.SistemaDeVendas.interfacies.IProduto;

import java.util.ArrayList;

public class ProdutoFacade {

    private ProdutoApplication produtoApplication;


    public ProdutoFacade( ProdutoApplication produtoApplication) {
        this.produtoApplication = produtoApplication;
    }

    public Produto buscarPorId(int id) {
        return this.produtoApplication.buscarPorId(id);
    }


    public ArrayList<Produto> buscarTodos() {
        return this.produtoApplication.buscarTodos();
    }


    public void salvar(int id, String codigoBarras, String nome, String descricao, float preco, int estoque, int minEstoque) {
        this.produtoApplication.salvar(id, codigoBarras, nome, descricao, preco, estoque, minEstoque);
    }


    public void atualizar(int id, Produto produtoAtualizado) {
        this.produtoApplication.atualizar(id, produtoAtualizado);
    }

    public void deletar(int id) {
        this.produtoApplication.deletar(id);
    }
}
