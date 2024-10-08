package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.ItemPedidoApplication;
import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemPedidoFacade {

    private ItemPedidoApplication itemPedidoApplication;

    @Autowired
    public ItemPedidoFacade(ItemPedidoApplication itemPedidoApplication) {
        this.itemPedidoApplication = itemPedidoApplication;
    }

    public ItemPedido buscarPorId(int id) {
        return this.itemPedidoApplication.buscarPorId(id);
    }

    public List<ItemPedido> buscarTodos() {
        return this.itemPedidoApplication.buscarTodos();
    }

    public void salvar(ItemPedido itemPedido) {
        itemPedidoApplication.salvar(itemPedido);
    }

    public void atualizar(int id, ItemPedido itemPedidoAtualizado) {
        this.itemPedidoApplication.atualizar(id, itemPedidoAtualizado);
    }

    public void deletar(int id) {
        this.itemPedidoApplication.deletar(id);
    }
}