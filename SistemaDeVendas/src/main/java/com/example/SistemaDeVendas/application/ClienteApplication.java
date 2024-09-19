package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.interfacies.ICliente;

import java.util.ArrayList;

public class ClienteApplication {

    private ICliente clienteRepository;

    
    public ClienteApplication(ICliente clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    
    public Cliente buscarPorId(int id) {
        return this.clienteRepository.buscarPorId(id);
    }

    
    public ArrayList<Cliente> buscarTodos() {
        return this.clienteRepository.buscarTodos();
    }

    
    public void salvar(int id, String nome, String cpf, String telefone, String email, String endereco) {
        this.clienteRepository.salvar(id, nome, cpf, telefone, email, endereco);
    }

    
    public void atualizar(int id, Cliente clienteAtualizado) {
        this.clienteRepository.atualizar(id, clienteAtualizado);
    }

    
    public void deletar(int id) {
        this.clienteRepository.deletar(id);
    }
}
