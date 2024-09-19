package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPagamento;

import java.util.ArrayList;

public class PagamentoApplication {

    private IPagamento pagamentoRepository;


    public PagamentoApplication(IPagamento pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento buscarPorId(int id) {
        return this.pagamentoRepository.buscarPorId(id);
    }


    public ArrayList<Pagamento> buscarTodos() {
        return this.pagamentoRepository.buscarTodos();
    }


    public void salvar(int id, Pedido idPedido, TipoPagamento idPagamento, float valor) {
        this.pagamentoRepository.salvar(id, idPedido, idPagamento, valor);
    }


    public void atualizar(int id, Pagamento pagamentoAtualizado) {
        this.pagamentoRepository.atualizar(id, pagamentoAtualizado);
    }

    public void deletar(int id) {
        this.pagamentoRepository.deletar(id);
    }
}