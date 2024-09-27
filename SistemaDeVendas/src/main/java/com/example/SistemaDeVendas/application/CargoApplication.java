package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.interfacies.ICargo;
import java.util.ArrayList;

public class CargoApplication implements ICargo{

    private ICargo cargoRepository; 

    
    public CargoApplication(ICargo cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    
    public Cargo buscarPorId(int id) {
        return this.cargoRepository.buscarPorId(id);
    }

    
    public ArrayList<Cargo> buscarTodos() {
        return this.cargoRepository.buscarTodos();
    }

    
    public void salvar(int id, String nomeCargo, float salario) {
        this.cargoRepository.salvar(id, nomeCargo, salario);
    }

    
    public void atualizar(int id, Cargo cargo) {
        this.cargoRepository.atualizar(id, cargo);
    }
    
    public void deletar(int id) {
        this.cargoRepository.deletar(id);
    }
}
