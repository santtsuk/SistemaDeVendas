package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.interfacies.IItemPedido;

import java.util.ArrayList;

public class ItemPedidoApplication {

    private IItemPedido itemPedidoRepository;


    public ItemPedidoApplication(IItemPedido itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public Pagamento buscarPorId(int id) {
        return this.itemPedidoRepository.buscarPorId(id);
    }


    public ArrayList<Pagamento> buscarTodos() {
        return this.itemPedidoRepository.buscarTodos();
    }


    public void salvar(int id, Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario) {
        this.itemPedidoRepository.salvar(id, idPedido, idProduto, quantidade, precoUnitario);
    }


    public void atualizar(int id, Pagamento itemPedidoAtualizado) {
        this.itemPedidoRepository.atualizar(id, itemPedidoAtualizado);
    }

    public void deletar(int id) {
        this.itemPedidoRepository.deletar(id);
    }
}