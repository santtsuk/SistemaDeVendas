package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.interfacies.IProduto;

import java.util.ArrayList;

public class RProduto implements IProduto {

    ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    public Produto buscarPorId(int id) {

        Produto buscarProduto = produtos.stream().filter(p -> p.getId() == id).findFirst().get();
        return buscarProduto;
    }

    @Override
    public ArrayList<Produto> buscarTodos() {

        return produtos;
    }

    @Override
    public void salvar(int id, String codigoBarras, String nome, String descricao, float preco, int estoque, int minEstoque) {

        Produto produtoNovo = new Produto(id, codigoBarras, nome, descricao, preco, estoque, minEstoque);
        produtos.add(produtoNovo);
    }

    @Override
    public void atualizar(int id, Produto produto) {

        Produto produtoUpdate = buscarPorId(id);

        produtoUpdate.setCodigoBarras(produto.getCodigoBarras());
        produtoUpdate.setNome(produto.getNome());
        produtoUpdate.setDescricao(produto.getDescricao());
        produtoUpdate.setPreco(produto.getPreco());
        produtoUpdate.setEstoque(produto.getEstoque());
        produtoUpdate.setMinEstoque(produto.getMinEstoque());
    }

    @Override
    public void deletar(int id) {

        produtos.removeIf(delete -> delete.getId() == id);
    }
}