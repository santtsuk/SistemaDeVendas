package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.entities.Cliente;

import java.util.ArrayList;

public interface ICliente {

    public Cliente buscarPorId(int id);

    public ArrayList<Cliente> buscarTodos();

    public void salvar(int id, String nome, String cpf, String telefone, String email, String endereco);

    public void atualizar(int id, Cliente cliente);

    public void deletar(int id);

}

