package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.CargoApplication;
import com.example.SistemaDeVendas.entities.Cargo;

import java.util.ArrayList;

public class CargoFacade {

    private CargoApplication cargoApplication;

    
    public CargoFacade(CargoApplication cargoApplication) {
        this.cargoApplication = cargoApplication;
    }
    

    public Cargo buscarPorId(int id) {
        return cargoApplication.buscarPorId(id);
    }

    public ArrayList<Cargo> buscarTodos() {
        return cargoApplication.buscarTodos();
    }

    public void salvar(int id, String nomeCargo, float salario) {
        cargoApplication.salvar(id, nomeCargo, salario);
    }

    public void atualizar(int id, Cargo cargoAtualizado) {
        cargoApplication.atualizar(id, cargoAtualizado);
    }

    public void deletar(int id) {
        cargoApplication.deletar(id);
    }
}
