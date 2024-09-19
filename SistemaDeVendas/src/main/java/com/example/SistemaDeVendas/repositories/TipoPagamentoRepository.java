package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.interfacies.ITipoPagamento;

import java.util.ArrayList;

public class TipoPagamentoRepository implements ITipoPagamento {

    ArrayList<TipoPagamento> tipoPagamentos = new ArrayList<>();

    @Override
    public TipoPagamento buscarPorId(int id) {

        TipoPagamento buscarTipoPagamento = tipoPagamentos.stream().filter(p -> p.getId() == id).findFirst().get();
        return buscarTipoPagamento;
    }

    @Override
    public ArrayList<TipoPagamento> buscarTodos() {

        return tipoPagamentos;
    }

    @Override
    public void salvar(int id, String descricao) {

        TipoPagamento tipoPagamentoNovo = new TipoPagamento(id, descricao);
        tipoPagamentos.add(tipoPagamentoNovo);
    }

    @Override
    public void atualizar(int id, TipoPagamento tipoPagamento) {

        TipoPagamento tipoPagamentoUpdate = buscarPorId(id);

        tipoPagamentoUpdate.setDescricao(tipoPagamento.getDescricao());
    }

    @Override
    public void deletar(int id) {

        tipoPagamentos.removeIf(delete -> delete.getId() == id);
    }
}