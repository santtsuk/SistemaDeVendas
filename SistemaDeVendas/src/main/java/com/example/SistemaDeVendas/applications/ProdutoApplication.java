package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IProduto;

import java.util.ArrayList;

public class ProdutoApplication {

    private IProduto produtoRepository;


    public ProdutoApplication( IProduto produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto buscarPorId(int id) {
        return this.produtoRepository.buscarPorId(id);
    }


    public ArrayList<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }


    public void salvar(int id, String codigoBarras, String nome, String descricao, float preco, int estoque, int minEstoque) {
        this.produtoRepository.salvar(id, codigoBarras, nome, descricao, preco, estoque, minEstoque);
    }


    public void atualizar(int id, Produto produtoAtualizado) {
        this.produtoRepository.atualizar(id, produtoAtualizado);
    }

    public void deletar(int id) {
        this.produtoRepository.deletar(id);
    }
}