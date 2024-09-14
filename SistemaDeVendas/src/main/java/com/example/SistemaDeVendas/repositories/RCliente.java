package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.interfacies.ICliente;

import java.util.ArrayList;

public class RCliente implements ICliente {

    ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente buscarPorId(int id) {

        Cliente buscarCliente = clientes.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarCliente;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() {

        return clientes;
    }

    @Override
    public void salvar(int id, String nome, String cpf, String telefone, String email, String endereco) {

        Cliente clienteNovo = new Cliente(id, nome, cpf, telefone, email, endereco);
        clientes.add(clienteNovo);
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