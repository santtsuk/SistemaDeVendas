package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.facades.CargoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CargoController {
    private CargoFacade cargoFacade;

    public void inicializarProdutos() {
      cargoFacade.salvar(1,"auxiliar Administrativo",1412);
    }

    @Autowired
    public CargoController(CargoFacade cargoFacade) {
        this.cargoFacade = cargoFacade;
        inicializarProdutos();
    }

    @GetMapping("/buscarCargos")
    public ResponseEntity<ArrayList<Cargo>> buscarTodos() {
        ArrayList<Cargo> cargos = cargoFacade.buscarTodos();

        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/buscarProduto/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable int id) {
        Cargo cargo = cargoFacade.buscarPorId(id);

        return ResponseEntity.ok(cargo);
    }
}
