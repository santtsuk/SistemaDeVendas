package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.repositories.ItemPedidoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoApplication implements ItemPedido {

    private ItemPedidoRepositoryMySql itemPedidoRepository;

    @Autowired
    public ItemPedidoApplication(ItemPedidoRepositoryMySql itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public ItemPedido buscarPorId(int id) {
        return this.itemPedidoRepository.buscarPorId(id);
    }

    public List<ItemPedido> buscarTodos() {
        return this.itemPedidoRepository.buscarTodos();
    }

    public void salvar(ItemPedido itemPedido) {
        this.itemPedidoRepository.salvar(itemPedido);
    }

    public void atualizar(int id, ItemPedido itemPedido) {
        ItemPedido ItemPedidoInDB = this.itemPedidoRepository.buscarPorId(id);

        if (ItemPedidoInDB == null)
            return;

        this.itemPedidoRepository.atualizar(id, cargo);
    }

    public void deletar(int id) {
        this.itemPedidoRepository.deletar(id);
    }
}