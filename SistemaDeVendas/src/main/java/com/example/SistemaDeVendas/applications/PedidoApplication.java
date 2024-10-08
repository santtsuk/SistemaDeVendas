package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.interfacies.IPedido;
import com.example.SistemaDeVendas.repositories.PedidoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoApplication implements IPedido {

    private final PedidoRepositoryMySql pedidoRepository;

    @Autowired
    public PedidoApplication(PedidoRepositoryMySql pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscarPorId(int id) {
        return this.pedidoRepository.buscarPorId(id);
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.buscarTodos();
    }

    public void salvar(Pedido pedido) {
        this.pedidoRepository.salvar(pedido);
    }

    public void atualizar(int id, Pedido pedido) {
        Pedido pedidoInDB = this.pedidoRepository.buscarPorId(id);

        if (pedidoInDB == null)
            return;

        this.pedidoRepository.atualizar(id, pedido);
    }

    public void deletar(int id) {
        this.pedidoRepository.deletar(id);
    }

}