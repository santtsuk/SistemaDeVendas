package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICliente {

    public Cliente buscarPorId(int id);

    public List<Cliente> buscarTodos();

    public void salvar(Cliente cliente);

    public void atualizar(int id, Cliente cliente);

    public void deletar(int id);

}

