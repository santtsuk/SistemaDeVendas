package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Funcionario;

import java.util.List;

public interface IFuncionario {

    public Funcionario buscarPorId(int id);

    public List<Funcionario> buscarTodos();

    public void salvar(int id, String nome, String cpf, String cargo, String setor, String dataAdimissao);

    public void atualizar(int id, Funcionario funcionario);

    public void deletar(int id);
}