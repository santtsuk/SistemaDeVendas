package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.FuncionarioApplication;
import com.example.SistemaDeVendas.entities.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionarioFacade {

    private FuncionarioApplication funcionarioApplication;

    @Autowired
    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }

    public Funcionario buscarPorId(int id) {
        return this.funcionarioApplication.buscarPorId(id);
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioApplication.buscarTodos();
    }

    public void salvar(Funcionario funcionario) {
        funcionarioApplication.salvar(funcionario);
    }

    public void atualizar(int id, Funcionario funcionarioAtualizado) {
        this.funcionarioApplication.atualizar(id, funcionarioAtualizado);
    }

    public void deletar(int id) {
        this.funcionarioApplication.deletar(id);
    }
}