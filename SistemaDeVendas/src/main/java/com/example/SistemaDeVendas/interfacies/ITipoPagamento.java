package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.TipoPagamento;

import java.util.ArrayList;

public interface ITipoPagamento {

    public TipoPagamento buscarPorId(int id);

    public ArrayList<TipoPagamento> buscarTodos();

    public void salvar(int id, String descricao);

    public void atualizar(int id, TipoPagamento tipoPagamento);

    public void deletar(int id);

}
