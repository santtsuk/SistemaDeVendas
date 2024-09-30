package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.ClienteApplication;
import com.example.SistemaDeVendas.entities.Cliente;

import java.util.List;

public class ClienteFacade {

    private ClienteApplication clienteApplication;

    public ClienteFacade(ClienteApplication clienteApplication) {
        this.clienteApplication = clienteApplication;
    }

    public Cliente buscarPorId(int id) {
        return clienteApplication.buscarPorId(id);
    }

    public List<Cliente> buscarTodos() {
        return clienteApplication.buscarTodos();
    }

    public void salvar(Cliente cliente) {
        clienteApplication.salvar(cliente);
    }

    public void atualizar(int id, Cliente clienteAtualizado) {
        clienteApplication.atualizar(id, clienteAtualizado);
    }

    public void deletar(int id) {
        clienteApplication.deletar(id);
    }
}
