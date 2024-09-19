package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.interfacies.IDescontoFidelidade;

import java.util.ArrayList;

public class DescontoFidelidadeApplication implements IDescontoFidelidade{

    private IDescontoFidelidade descontoFidelidadeRepository;

    
    public DescontoFidelidadeApplication(IDescontoFidelidade descontoFidelidadeRepository) {
        this.descontoFidelidadeRepository = descontoFidelidadeRepository;
    }

    
    public DescontoFidelidade buscarPorId(int id) {
        return this.descontoFidelidadeRepository.buscarPorId(id);
    }

    
    public ArrayList<DescontoFidelidade> buscarTodos() {
        return this.descontoFidelidadeRepository.buscarTodos();
    }

    
    public void salvar(int id, Cliente idCliente, float valorDesconto, String dataAplicacao) {
        this.descontoFidelidadeRepository.salvar(id, idCliente, valorDesconto, dataAplicacao);
    }

    
    public void atualizar(int id, DescontoFidelidade descontoFidelidade) {
        this.descontoFidelidadeRepository.atualizar(id, descontoFidelidade);
    }

    
    public void deletar(int id) {
        this.descontoFidelidadeRepository.deletar(id);
    }
}
