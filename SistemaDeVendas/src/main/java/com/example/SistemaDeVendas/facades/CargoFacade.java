package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.CargoApplication;
import com.example.SistemaDeVendas.entities.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CargoFacade {

    private CargoApplication cargoApplication;
    @Autowired
    public CargoFacade(CargoApplication cargoApplication) {
        this.cargoApplication = cargoApplication;
    }
    
    public Cargo buscarPorId(int id) {
        return cargoApplication.buscarPorId(id);
    }

    public List<Cargo> buscarTodos() {
        return cargoApplication.buscarTodos();
    }

    public void salvar(Cargo cargo) {
        cargoApplication.salvar(cargo);
    }

    public void atualizar(int id, Cargo cargoAtualizado) {
        cargoApplication.atualizar(id, cargoAtualizado);
    }

    public void deletar(int id) {
        cargoApplication.deletar(id);
    }
}
