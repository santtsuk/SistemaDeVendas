package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;

import java.util.List;

public interface IItemPedido {

    public Pagamento buscarPorId(int id);

    public List<Pagamento> buscarTodos();

    public void salvar(int id, Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario);

    public void atualizar(int id, Pagamento itemPedido);

    public void deletar(int id);
}