package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.*;

import java.util.List;

public interface IProduto {
    public Produto buscarPorId(int id);

    public List<Produto> buscarTodos();

    public void salvar(Produto produto);

    public void atualizar(int id, Produto produto);

    public void deletar(int id);

}