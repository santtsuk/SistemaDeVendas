package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.*;

import java.util.ArrayList;

public interface IProduto {
    public Produto buscarPorId(int id);

    public ArrayList<Produto> buscarTodos();

    public void salvar(int id, String codigoBarras, String nome, String descricao, float preco, int estoque, int minEstoque);

    public void atualizar(int id, Produto produto);

    public void deletar(int id);

}
