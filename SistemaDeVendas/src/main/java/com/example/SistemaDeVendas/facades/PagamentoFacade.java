package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.PagamentoApplication;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.TipoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PagamentoFacade {

    private PagamentoApplication pagamentoApplication;
    @Autowired
    public PagamentoFacade(PagamentoApplication pagamentoApplication) {
        this.pagamentoApplication = pagamentoApplication;
    }

    public Pagamento buscarPorId(int id) {
        return pagamentoApplication.buscarPorId(id);
    }

    public List<Pagamento> buscarTodos() {
        return pagamentoApplication.buscarTodos();
    }

    public void salvar(Pagamento pagamento) {
        pagamentoApplication.salvar(pagamento);
    }

    public void atualizar(int id, Pagamento pagamentoAtualizado) {
       pagamentoApplication.atualizar(id, pagamentoAtualizado);
    }

    public void deletar(int id) {
        pagamentoApplication.deletar(id);
    }
}