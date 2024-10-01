package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.facades.CargoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CargoController {
    private final CargoFacade cargoFacade;

    @Autowired
    public CargoController(CargoFacade cargoFacade) {
        this.cargoFacade = cargoFacade;
    }


    @GetMapping("/buscarCargos")
    public ResponseEntity<List<Cargo>> buscarTodos() {
        List<Cargo> cargos = cargoFacade.buscarTodos();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/buscarCargos/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable int id) {
        Cargo cargo = cargoFacade.buscarPorId(id);
        return cargo != null ? ResponseEntity.ok(cargo) : ResponseEntity.notFound().build();
    }
}
