package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.PedidoApplication;
import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Usuario;

import java.util.ArrayList;

public class PedidoFacade {

    private PedidoApplication pedidoApplication;


    public PedidoFacade(PedidoApplication pedidoApplication) {
        this.pedidoApplication = pedidoApplication;
    }

    public Pedido buscarPorId(int id) {
        return this.pedidoApplication.buscarPorId(id);
    }


    public ArrayList<Pedido> buscarTodos() {
        return this.pedidoApplication.buscarTodos();
    }


    public void salvar(int id, String dataPedido, Cliente idCliente, float valorTotal, Pagamento idPagamento, Usuario idUsuario) {
        this.pedidoApplication.salvar(id, dataPedido, idCliente, valorTotal, idPagamento, idUsuario);
    }


    public void atualizar(int id, Pedido pedidoAtualizado) {
        this.pedidoApplication.atualizar(id, pedidoAtualizado);
    }

    public void deletar(int id) {
        this.pedidoApplication.deletar(id);
    }
}
