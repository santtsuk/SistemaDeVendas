package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.ClienteApplication;
import com.example.SistemaDeVendas.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ClienteFacade {

    private ClienteApplication clienteApplication;
    @Autowired
    public ClienteFacade(ClienteApplication clienteApplication) {
        this.clienteApplication = clienteApplication;
    }

    public Cliente buscarPorId(int id) {
        return clienteApplication.buscarPorId(id);
    }

    public List<Cliente> buscarTodos() {
        return clienteApplication.buscarTodos();
    }

    public Cliente salvar(Cliente cliente) {
        clienteApplication.salvar(cliente);
        return cliente;
    }

    public Cliente atualizar(int id, Cliente clienteAtualizado) {
        clienteApplication.atualizar(id, clienteAtualizado);
        return clienteAtualizado;
    }

    public boolean deletar(int id) {
        clienteApplication.deletar(id);
        return false;
    }
}
