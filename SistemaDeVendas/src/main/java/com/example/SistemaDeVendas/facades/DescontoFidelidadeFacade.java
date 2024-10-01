package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.DescontoFidelidadeApplication;
import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public void salvar(DescontoFidelidade descontoFidelidade) {
        descontoFidelidadeApplication.salvar(descontoFidelidade);
    }

    public void atualizar(int id, DescontoFidelidade descontoAtualizado) {
        descontoFidelidadeApplication.atualizar(id, descontoAtualizado);
    }

    public void deletar(int id) {
        descontoFidelidadeApplication.deletar(id);
    }
}
