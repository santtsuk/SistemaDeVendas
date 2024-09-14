package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.*;

import java.util.ArrayList;

public interface IPagamento {

    public Pagamento buscarPorId(int id);

    public ArrayList<Pagamento> buscarTodos();

    public void salvar(int id, Pedido idPedido, TipoPagamento idPagamento, float valor);

    public void atualizar(int id, Pagamento pagamento);

    public void deletar(int id);

}
