package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.TipoPagamento;

import java.util.List;

public interface ITipoPagamento {


    public TipoPagamento buscarPorId(int id);

    public List<TipoPagamento> buscarTodos();

    public void salvar(TipoPagamento tipoPagamento);

    public void atualizar(int id, TipoPagamento tipoPagamento);


    public void deletar(int id);

}