package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Pedido;

import java.util.List;

    public interface IPedido {
        public Pedido buscarPorId(int id);

        public List<Pedido> buscarTodos();

        public void salvar(Pedido pedido);

        public void atualizar(int id,Pedido pedido);

        public void deletar(int id);

}
