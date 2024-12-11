package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.interfacies.IItemPedido;
import com.example.SistemaDeVendas.repositories.ItemPedidoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.PedidoRepositoryMySql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemPedidoApplication implements IItemPedido {

    private ItemPedidoRepositoryMySql itemPedidoRepository;
    private PedidoRepositoryMySql pedidoRepository;

    @Autowired
    public ItemPedidoApplication(ItemPedidoRepositoryMySql itemPedidoRepository,PedidoRepositoryMySql pedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public ItemPedido buscarPorId(int id) {
        return this.itemPedidoRepository.buscarPorId(id);
    }

    public List<ItemPedido> buscarTodos() {
        return this.itemPedidoRepository.buscarTodos();
    }

    @Transactional
    public void salvar(ItemPedido itemPedido) {
        this.itemPedidoRepository.salvar(itemPedido);
        atualizarValorTotalPedido(itemPedido.getIdPedido().getId());
    }

    public void atualizar(int id, ItemPedido itemPedido) {
        ItemPedido ItemPedidoInDB = this.itemPedidoRepository.buscarPorId(id);

        if (ItemPedidoInDB == null)
            return;

        this.itemPedidoRepository.atualizar(id, itemPedido);
    }

    public void deletar(int id) {
        ItemPedido itemPedido = itemPedidoRepository.buscarPorId(id);
        this.itemPedidoRepository.deletar(id);
        atualizarValorTotalPedido(itemPedido.getIdPedido().getId());
    }
    public void atualizarValorTotalPedido(int pedidoId){
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if(pedido != null){
            pedido.calcularValorTotal();
            pedido.atualizarStatusPagamento();
            pedidoRepository.atualizar(pedido.getId(),pedido);
        }
    }
}