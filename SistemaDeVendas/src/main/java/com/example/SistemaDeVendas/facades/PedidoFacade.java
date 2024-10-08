package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.PedidoApplication;
import com.example.SistemaDeVendas.applications.ProdutoApplication;
import com.example.SistemaDeVendas.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PedidoFacade {

    private PedidoApplication pedidoApplication;

    public PedidoFacade(PedidoApplication pedidoApplication) {
        this.pedidoApplication = pedidoApplication;
    }

    public Pedido buscarPorId(int id) {
        return this.pedidoApplication.buscarPorId(id);
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoApplication.buscarTodos();
    }

    public Pedido salvar(Pedido pedido) {
        pedidoApplication.salvar(pedido);
        return pedido;
    }

    public void atualizar(int id, Pedido pedidoAtualizado) {
        this.pedidoApplication.atualizar(id, pedidoAtualizado);
    }

    public void deletar(int id) {
        this.pedidoApplication.deletar(id);
    }
}