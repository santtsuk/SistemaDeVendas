package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.ItemPedidoApplication;
import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;

import java.util.ArrayList;

public class ItemPedidoFacade {

    private ItemPedidoApplication itemPedidoApplication;

    public ItemPedidoFacade(ItemPedidoApplication itemPedidoApplication) {
        this.itemPedidoApplication = itemPedidoApplication;
    }

    public ItemPedido buscarPorId(int id) {
        return this.itemPedidoApplication.buscarPorId(id);
    }

    public ArrayList<ItemPedido> buscarTodos() {
        return this.itemPedidoApplication.buscarTodos();
    }

    public void salvar(int id, Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario) {
        this.itemPedidoApplication.salvar(id, idPedido, idProduto, quantidade, precoUnitario);
    }

    public void atualizar(int id, ItemPedido itemPedidoAtualizado) {
        this.itemPedidoApplication.atualizar(id, itemPedidoAtualizado);
    }

    public void deletar(int id) {
        this.itemPedidoApplication.deletar(id);
    }
}