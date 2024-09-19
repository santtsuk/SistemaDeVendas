package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.FuncionarioApplication;
import com.example.SistemaDeVendas.entities.Funcionario;

import java.util.ArrayList;

public class FuncionarioFacade {


    private FuncionarioApplication funcionarioApplication;


    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }


    public Funcionario buscarPorId(int id) {
        return this.funcionarioApplication.buscarPorId(id);
    }


    public ArrayList<Funcionario> buscarTodos() {
        return this.funcionarioApplication.buscarTodos();
    }


    public void salvar(int id, String nome, String cpf, String cargo, String setor, String dataAdimissao) {
        this.funcionarioApplication.salvar(id, nome, cpf, cargo, setor, dataAdimissao);
    }


    public void atualizar(int id, Funcionario funcionarioAtualizado) {
        this.funcionarioApplication.atualizar(id, funcionarioAtualizado);
    }

    public void deletar(int id) {
        this.funcionarioApplication.deletar(id);
    }
}
