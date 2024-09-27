package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.interfacies.ICliente;

import java.util.ArrayList;

public class ClienteRepositoryMySql implements ICliente {
    @Override
    public Cliente buscarPorId(int id) {
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public void salvar(int id, String nome, String cpf, String telefone, String email, String endereco) {

    }

    @Override
    public void atualizar(int id, Cliente cliente) {

    }

    @Override
    public void deletar(int id) {

    }
}
