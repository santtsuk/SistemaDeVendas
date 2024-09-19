package com.example.SistemaDeVendas.facade;

import com.example.SistemaDeVendas.applications.ClienteApplication;
import com.example.SistemaDeVendas.entities.Cliente;

import java.util.ArrayList;

public class ClienteFacade {

    private ClienteApplication clienteApplication;

    public ClienteFacade(ClienteApplication clienteApplication) {
        this.clienteApplication = clienteApplication;
    }

    public Cliente buscarPorId(int id) {
        return clienteApplication.buscarPorId(id);
    }

    public ArrayList<Cliente> buscarTodos() {
        return clienteApplication.buscarTodos();
    }

    public void salvar(int id, String nome, String cpf, String telefone, String email, String endereco) {
        clienteApplication.salvar(id, nome, cpf, telefone, email, endereco);
    }

    public void atualizar(int id, Cliente clienteAtualizado) {
        clienteApplication.atualizar(id, clienteAtualizado);
    }

    public void deletar(int id) {
        clienteApplication.deletar(id);
    }
}
