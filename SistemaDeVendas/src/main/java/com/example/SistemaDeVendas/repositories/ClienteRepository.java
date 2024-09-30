package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.interfacies.ICliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements ICliente {

    ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente buscarPorId(int id) {

        Cliente buscarCliente = clientes.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarCliente;
    }

    @Override
    public List<Cliente> buscarTodos() {

        return clientes;
    }

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizar(int id, Cliente cliente) {

        Cliente clienteUpdate = buscarPorId(id);

        clienteUpdate.setNome(cliente.getNome());
        clienteUpdate.setCpf(cliente.getCpf());
        clienteUpdate.setTelefone(cliente.getTelefone());
        clienteUpdate.setEmail(cliente.getEmail());
        clienteUpdate.setEndereco(cliente.getEndereco());
    }

    @Override
    public void deletar(int id) {

        clientes.removeIf(delete -> delete.getId() == id);
    }

}