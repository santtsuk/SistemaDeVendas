package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPedido;

import java.util.ArrayList;

public class PedidoApplication {

    private IPedido pedidoRepository;


    public PedidoApplication(IPedido pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscarPorId(int id) {
        return this.pedidoRepository.buscarPorId(id);
    }


    public ArrayList<Pedido> buscarTodos() {
        return this.pedidoRepository.buscarTodos();
    }


    public void salvar(int id, String dataPedido, Cliente idCliente, float valorTotal, Pagamento idPagamento, Usuario idUsuario) {
        this.pedidoRepository.salvar(id, dataPedido, idCliente, valorTotal, idPagamento, idUsuario);
    }


    public void atualizar(int id, Pedido pedidoAtualizado) {
        this.pedidoRepository.atualizar(id, pedidoAtualizado);
    }

    public void deletar(int id) {
        this.pedidoRepository.deletar(id);
    }
}