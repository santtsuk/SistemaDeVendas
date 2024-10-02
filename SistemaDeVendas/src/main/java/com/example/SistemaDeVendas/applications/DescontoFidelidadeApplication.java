package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.interfacies.IDescontoFidelidade;
import com.example.SistemaDeVendas.repositories.DescontoFidelidadeRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DescontoFidelidadeApplication implements IDescontoFidelidade{

    private DescontoFidelidadeRepositoryMySql descontoFidelidadeRepository;

    @Autowired
    public DescontoFidelidadeApplication(DescontoFidelidadeRepositoryMySql descontoFidelidadeRepository) {
        this.descontoFidelidadeRepository = descontoFidelidadeRepository;
    }

    
    public DescontoFidelidade buscarPorId(int id) {
        return this.descontoFidelidadeRepository.buscarPorId(id);
    }

    
    public List<DescontoFidelidade> buscarTodos() {
        return this.descontoFidelidadeRepository.buscarTodos();
    }

    
    public void salvar(DescontoFidelidade descontoFidelidade) {
        this.descontoFidelidadeRepository.salvar(descontoFidelidade);
    }

    
    public void atualizar(int id, DescontoFidelidade descontoFidelidade) {
        this.descontoFidelidadeRepository.atualizar(id, descontoFidelidade);
    }

    
    public void deletar(int id) {
        this.descontoFidelidadeRepository.deletar(id);
    }
}
