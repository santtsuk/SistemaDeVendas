package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.interfacies.IFuncionario;

import java.util.ArrayList;

public class FuncionarioApplication {

    private IFuncionario funcionarioRepository;


    public FuncionarioApplication(IFuncionario funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public Funcionario buscarPorId(int id) {
        return this.funcionarioRepository.buscarPorId(id);
    }


    public ArrayList<Funcionario> buscarTodos() {
        return this.funcionarioRepository.buscarTodos();
    }


    public void salvar(int id, String nome, String cpf, String cargo, String setor, String dataAdimissao) {
        this.funcionarioRepository.salvar(id, nome, cpf, cargo, setor, dataAdimissao);
    }


    public void atualizar(int id, Funcionario funcionarioAtualizado) {
        this.funcionarioRepository.atualizar(id, funcionarioAtualizado);
    }

    public void deletar(int id) {
        this.funcionarioRepository.deletar(id);
    }
}