package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.interfacies.IDescontoFidelidade;

import java.util.ArrayList;

public class DescontoFidelidadeRepositoryMySql implements IDescontoFidelidade {
    @Override
    public DescontoFidelidade buscarPorId(int id) {
        return null;
    }

    @Override
    public ArrayList<DescontoFidelidade> buscarTodos() {
        return null;
    }

    @Override
    public void salvar(int id, Cliente idCliente, float valorDesconto, String dataAplicacao) {

    }

    @Override
    public void atualizar(int id, DescontoFidelidade descontoFidelidade) {

    }

    @Override
    public void deletar(int id) {

    }
}
