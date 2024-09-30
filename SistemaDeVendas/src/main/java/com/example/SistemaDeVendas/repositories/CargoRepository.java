package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.interfacies.ICargo;

import java.util.ArrayList;
import java.util.List;

public class CargoRepository implements ICargo {

    ArrayList<Cargo> cargos = new ArrayList<>();

    @Override
    public Cargo buscarPorId(int id) {

        Cargo buscarCargo = cargos.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarCargo;
    }

    @Override
    public List<Cargo> buscarTodos() {

        return cargos;
    }

    @Override
    public void salvar(Cargo cargo) {

        cargos.add(cargo);
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