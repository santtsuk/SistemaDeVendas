package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.interfacies.IFuncionario;

import java.util.ArrayList;

public class FuncionarioRepository implements IFuncionario {


    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public Funcionario buscarPorId(int id) {
        Funcionario buscarFuncionario = funcionarios.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarFuncionario;
    }

    @Override
    public ArrayList<Funcionario> buscarTodos() {

        return funcionarios;
    }

    @Override
    public void salvar(int id, String nome, String cpf, String cargo, String setor, String dataAdimissao) {

        Funcionario funcionarioNovo = new Funcionario(id, nome, cpf, cargo, setor, dataAdimissao);
        funcionarios.add(funcionarioNovo);
    }

    @Override
    public void atualizar(int id, Funcionario funcionario) {

        Funcionario funcionarioUpdate = buscarPorId(id);

        funcionarioUpdate.setNome(funcionario.getNome());
        funcionarioUpdate.setCpf(funcionario.getCpf());
        funcionarioUpdate.setCargo(funcionario.getCargo());
        funcionarioUpdate.setSetor(funcionario.getSetor());
        funcionarioUpdate.setDataAdimissao(funcionario.getDataAdimissao());
    }

    @Override
    public void deletar(int id) {

        funcionarios.removeIf(delete -> delete.getId() == id);
    }
}