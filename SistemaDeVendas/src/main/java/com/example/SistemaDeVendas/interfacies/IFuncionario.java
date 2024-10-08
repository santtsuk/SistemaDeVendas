package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Funcionario;

import java.util.List;

public interface IFuncionario {

    public Funcionario buscarPorId(int id);

    public List<Funcionario> buscarTodos();

    public void salvar(Funcionario funcionario);

    public void atualizar(int id, Funcionario funcionario);

    public void deletar(int id);
}