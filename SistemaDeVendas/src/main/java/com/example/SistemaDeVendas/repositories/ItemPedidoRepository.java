package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.interfacies.IItemPedido;

import java.util.ArrayList;

public class ItemPedidoRepository implements IItemPedido {

    ArrayList<Pagamento> itemPedidos = new ArrayList<>();

    @Override
    public Pagamento buscarPorId(int id) {
        Pagamento buscarItempedido = itemPedidos.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarItempedido;
    }

    @Override
    public ArrayList<Pagamento> buscarTodos() {

        return itemPedidos;
    }

    @Override
    public void salvar(int id, Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario) {

        Pagamento itemPedidoNovo = new Pagamento(id, idPedido, idProduto, quantidade, precoUnitario);
        itemPedidos.add(itemPedidoNovo);
    }

    @Override
    public void atualizar(int id, Pagamento itemPedido) {

        Pagamento itemPedidoUpdate = buscarPorId(id);

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