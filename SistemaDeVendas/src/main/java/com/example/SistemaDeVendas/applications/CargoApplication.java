package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.interfacies.ICargo;
import com.example.SistemaDeVendas.repositories.CargoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoApplication implements ICargo{

    private CargoRepositoryMySql cargoRepository;

    @Autowired
    public CargoApplication(CargoRepositoryMySql cargoRepository) {
        this.cargoRepository = cargoRepository;
    }


    public Cargo buscarPorId(int id) {
        return this.cargoRepository.buscarPorId(id);
    }


    public List<Cargo> buscarTodos() {
        return this.cargoRepository.buscarTodos();
    }


    public void salvar(Cargo cargo) {
        this.cargoRepository.salvar(cargo);
    }


    public void atualizar(int id, Cargo cargo) {
        Cargo cargoInDB = this.cargoRepository.buscarPorId(id);

        if (cargoInDB == null)
            return;

        this.cargoRepository.atualizar(id, cargo);
    }

    public void deletar(int id) {
        this.cargoRepository.deletar(id);
    }

}
