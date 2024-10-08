package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;

import java.util.List;

public interface IItemPedido {

    public ItemPedido buscarPorId(int id);

    public List<ItemPedido> buscarTodos();

    public void salvar(ItemPedido itemPedido);

    public void atualizar(int id, ItemPedido itemPedido);

    public void deletar(int id);
}