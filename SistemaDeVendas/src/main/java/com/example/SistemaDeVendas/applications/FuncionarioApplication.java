package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.interfacies.IFuncionario;
import com.example.SistemaDeVendas.repositories.CargoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.FuncionarioRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioApplication  {

    private final FuncionarioRepositoryMySql funcionarioRepository;
    private final CargoRepositoryMySql cargoRepository;

    @Autowired
    public FuncionarioApplication(FuncionarioRepositoryMySql funcionarioRepository, CargoRepositoryMySql cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
    }

    public Funcionario buscarPorId(int id) {
        return this.funcionarioRepository.buscarPorId(id);
    }

    public List<Funcionario> buscarTodos() {
        return this.funcionarioRepository.buscarTodos();
    }

    public void salvar(Funcionario funcionario) {

        this.funcionarioRepository.salvar(funcionario);
    }

    public void atualizar(int id, Funcionario funcionario) {
        Funcionario funcionarioInDB = this.funcionarioRepository.buscarPorId(id);

        if (funcionarioInDB == null)
            return;

        this.funcionarioRepository.atualizar(id, funcionario);
    }

    public void deletar(int id) {this.funcionarioRepository.deletar(id);}
}