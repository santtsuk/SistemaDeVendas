package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.*;

import java.util.ArrayList;

public interface IPedido {

    public Pedido buscarPorId(int id);

    public ArrayList<Pedido> buscarTodos();

    public void salvar(int id, String dataPedido, Cliente idCliente, float valorTotal, Pagamento idPagamento, Usuario idUsuario);

    public void atualizar(int id, Pedido pedido);

    public void deletar(int id);

}
