package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.TipoPagamentoApplication;
import com.example.SistemaDeVendas.entities.TipoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoPagamentoFacade {

    private TipoPagamentoApplication tipoPagamentoApplication;
    @Autowired
    public TipoPagamentoFacade(TipoPagamentoApplication tipoPagamentoApplication) {
        this.tipoPagamentoApplication = tipoPagamentoApplication;
    }

    public TipoPagamento buscarPorId(int id) {
        return tipoPagamentoApplication.buscarPorId(id);
    }

    public List<TipoPagamento> buscarTodos() {
        return tipoPagamentoApplication.buscarTodos();
    }

    public void salvar(TipoPagamento tipoPagamento) {
        tipoPagamentoApplication.salvar(tipoPagamento);
    }

    public void atualizar(int id, TipoPagamento tipoPagamentoAtualizado) {
        tipoPagamentoApplication.atualizar(id, tipoPagamentoAtualizado);
    }

    public void deletar(int id) {
        tipoPagamentoApplication.deletar(id);
    }
}
