package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.interfacies.IPedido;

import java.util.ArrayList;

public class RPedido implements IPedido {

    ArrayList<Pedido> pedidos = new ArrayList<>();

    @Override
    public Pedido buscarPorId(int id) {

        Pedido buscarPedido = pedidos.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarPedido;
    }

    @Override
    public ArrayList<Pedido> buscarTodos() {

        return pedidos;
    }

    @Override
    public void salvar(int id, String dataPedido, Cliente idCliente, float valorTotal, Pagamento idPagamento, Usuario idUsuario) {

        Pedido pedidoNovo = new Pedido(id, dataPedido, idCliente, valorTotal, idPagamento, idUsuario);
        pedidos.add(pedidoNovo);
    }

    @Override
    public void atualizar(int id, Pedido pedido) {

        Pedido pedidoUpdate = buscarPorId(id);

        pedidoUpdate.setDataPedido(pedido.getDataPedido());
        pedidoUpdate.setIdCliente(pedido.getIdCliente());
        pedidoUpdate.setValorTotal(pedido.getValorTotal());
        pedidoUpdate.setIdPagamentos(pedido.getIdPagamentos());
        pedidoUpdate.setIdUsuario(pedido.getIdUsuario());
    }

    @Override
    public void deletar(int id) {

        pedidos.removeIf(delete -> delete.getId() == id);
    }
}