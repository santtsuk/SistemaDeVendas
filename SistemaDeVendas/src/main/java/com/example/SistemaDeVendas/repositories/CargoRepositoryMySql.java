package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.interfacies.ICargo;

import java.util.ArrayList;

public class CargoRepositoryMySql implements ICargo {
    @Override
    public Cargo buscarPorId(int id) {
        return null;
    }

    @Override
    public ArrayList<Cargo> buscarTodos() {
        return null;
    }

    @Override
    public void salvar(int id, String nomeCargo, float salario) {

    }

    @Override
    public void atualizar(int id, Cargo cargo) {

    }

    @Override
    public void deletar(int id) {

    }
}
