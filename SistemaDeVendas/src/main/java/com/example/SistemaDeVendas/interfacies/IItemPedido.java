package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;

import java.util.ArrayList;

public interface IItemPedido {

    public ItemPedido buscarPorId(int id);

    public ArrayList<ItemPedido> buscarTodos();

    public void salvar(int id, Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario);

    public void atualizar(int id, ItemPedido itemPedido);

    public void deletar(int id);
}