package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.interfacies.IItemPedido;

import java.util.ArrayList;

public class RItemPedido implements IItemPedido {

    ArrayList<ItemPedido> itemPedidos = new ArrayList<>();

    @Override
    public ItemPedido buscarPorId(int id) {
        ItemPedido buscarItempedido = itemPedidos.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarItempedido;
    }

    @Override
    public ArrayList<ItemPedido> buscarTodos() {

        return itemPedidos;
    }

    @Override
    public void salvar(int id, Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario) {

        ItemPedido itemPedidoNovo = new ItemPedido(id, idPedido, idProduto, quantidade, precoUnitario);
        itemPedidos.add(itemPedidoNovo);
    }

    @Override
    public void atualizar(int id, ItemPedido itemPedido) {

        ItemPedido itemPedidoUpdate = buscarPorId(id);

        itemPedidoUpdate.setIdPedido(itemPedido.getIdPedido());
        itemPedidoUpdate.setIdProduto(itemPedido.getIdProduto());
        itemPedidoUpdate.setQuantidade(itemPedido.getQuantidade());
        itemPedidoUpdate.setPrecoUnitario(itemPedido.getPrecoUnitario());
    }

    @Override
    public void deletar(int id) {

        itemPedidos.removeIf(delete -> delete.getId() == id);
    }
}