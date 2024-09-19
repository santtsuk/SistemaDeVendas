package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.TipoPagamentoApplication;
import com.example.SistemaDeVendas.entities.TipoPagamento;

import java.util.ArrayList;

public class TipoPagamentoFacade {


    private TipoPagamentoApplication TipoPagamentoApplication;


    public TipoPagamentoFacade( TipoPagamentoApplication TipoPagamentoApplication) {
        this.TipoPagamentoApplication = TipoPagamentoApplication;
    }

    public TipoPagamento buscarPorId(int id) {
        return this.TipoPagamentoApplication.buscarPorId(id);
    }


    public ArrayList<TipoPagamento> buscarTodos() {
        return this.TipoPagamentoApplication.buscarTodos();
    }


    public void salvar(int id, String descricao) {
        this.TipoPagamentoApplication.salvar(id, descricao);
    }


    public void atualizar(int id, TipoPagamento tipoRepositoryAtualizado) {
        this.TipoPagamentoApplication.atualizar(id, tipoRepositoryAtualizado);
    }

    public void deletar(int id) {
        this.TipoPagamentoApplication.deletar(id);
    }
}
