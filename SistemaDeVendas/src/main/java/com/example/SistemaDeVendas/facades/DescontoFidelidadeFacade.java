package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.DescontoFidelidadeApplication;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DescontoFidelidadeFacade {

    private DescontoFidelidadeApplication descontoFidelidadeApplication;

    @Autowired
    public DescontoFidelidadeFacade(DescontoFidelidadeApplication descontoFidelidadeApplication) {
        this.descontoFidelidadeApplication = descontoFidelidadeApplication;
    }
    
    public DescontoFidelidade buscarPorId(int id) {
        return descontoFidelidadeApplication.buscarPorId(id);
    }

    public List<DescontoFidelidade> buscarTodos() {
        return descontoFidelidadeApplication.buscarTodos();
    }

    public DescontoFidelidade salvar(DescontoFidelidade descontoFidelidade) {
        descontoFidelidadeApplication.salvar(descontoFidelidade);
        return descontoFidelidade;
    }

    public DescontoFidelidade atualizar(int id, DescontoFidelidade descontoAtualizado) {
        descontoFidelidadeApplication.atualizar(id, descontoAtualizado);
        return descontoAtualizado;
    }

    public boolean deletar(int id) {
        descontoFidelidadeApplication.deletar(id);
        return false;
    }
}
