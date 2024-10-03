package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.PagamentoApplication;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.TipoPagamento;

import java.util.ArrayList;

public class PagamentoFacade {

    private PagamentoApplication pagamentoApplication;

    public PagamentoFacade(PagamentoApplication pagamentoApplication) {
        this.pagamentoApplication = pagamentoApplication;
    }

    public Pagamento buscarPorId(int id) {
        return this.pagamentoApplication.buscarPorId(id);
    }

    public ArrayList<Pagamento> buscarTodos() {
        return this.pagamentoApplication.buscarTodos();
    }

    public void salvar(int id, Pedido idPedido, TipoPagamento idPagamento, float valor) {
        this.pagamentoApplication.salvar(id, idPedido, idPagamento, valor);
    }

    public void atualizar(int id, Pagamento pagamentoAtualizado) {
        this.pagamentoApplication.atualizar(id, pagamentoAtualizado);
    }

    public void deletar(int id) {
        this.pagamentoApplication.deletar(id);
    }
}