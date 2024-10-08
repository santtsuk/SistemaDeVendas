package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.repositories.ClienteRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ClienteApplication {

    private ClienteRepositoryMySql clienteRepository;

    @Autowired
    public ClienteApplication(ClienteRepositoryMySql cargoRepository) {
        this.clienteRepository = cargoRepository;
    }


    public Cliente buscarPorId(int id) {
        return this.clienteRepository.buscarPorId(id);
    }


    public List<Cliente> buscarTodos() {
        return this.clienteRepository.buscarTodos();
    }


    public void salvar(Cliente cliente) {
        this.clienteRepository.salvar(cliente);
    }


    public void atualizar(int id, Cliente cliente) {
        Cliente clienteInDB = this.clienteRepository.buscarPorId(id);

        if (clienteInDB == null)
            return;

        this.clienteRepository.atualizar(id, cliente);
    }

    public void deletar(int id) {
        this.clienteRepository.deletar(id);
    }
}
