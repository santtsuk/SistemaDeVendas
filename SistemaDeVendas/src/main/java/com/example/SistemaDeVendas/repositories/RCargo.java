package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.interfacies.ICargo;

import java.util.ArrayList;

public class RCargo implements ICargo {

    ArrayList<Cargo> cargos = new ArrayList<>();

    @Override
    public Cargo buscarPorId(int id) {

        Cargo buscarCargo = cargos.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarCargo;
    }

    @Override
    public ArrayList<Cargo> buscarTodos() {

        return cargos;
    }

    @Override
    public void salvar(int id, String nomeCargo, float salario) {

        Cargo cargoNovo = new Cargo(id, nomeCargo, salario);
        cargos.add(cargoNovo);
    }

    @Override
    public void atualizar(int id, Cargo cargo) {

        Cargo cargoUpdate = buscarPorId(id);

        cargoUpdate.setNomeCargo(cargo.getNomeCargo());
        cargoUpdate.setSalario(cargo.getSalario());
    }

    @Override
    public void deletar(int id) {

        cargos.removeIf(delete -> delete.getId() == id);
    }
}