package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.interfacies.IPagamento;

import java.util.ArrayList;

public class RPagamento implements IPagamento {

    ArrayList<Pagamento> pagamentos = new ArrayList<>();

    @Override
    public Pagamento buscarPorId(int id) {

        Pagamento buscarPagamento = pagamentos.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarPagamento;
    }

    @Override
    public ArrayList<Pagamento> buscarTodos() {

        return pagamentos;
    }

    @Override
    public void salvar(int id, Pedido idPedido, TipoPagamento idPagamento, float valor) {

        Pagamento pagamentoNovo = new Pagamento(id, idPedido, idPagamento, valor);
        pagamentos.add(pagamentoNovo);
    }

    @Override
    public void atualizar(int id, Pagamento pagamento) {

        Pagamento pagamentoUpdate = buscarPorId(id);

        pagamentoUpdate.setIdPedido(pagamento.getIdPedido());
        pagamentoUpdate.setIdPagamento(pagamento.getIdPagamento());
        pagamentoUpdate.setValor(pagamento.getValor());
    }

    @Override
    public void deletar(int id) {

        pagamentos.removeIf(delete -> delete.getId() == id);
    }
}