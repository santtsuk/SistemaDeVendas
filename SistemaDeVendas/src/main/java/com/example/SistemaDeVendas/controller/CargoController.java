package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.facades.CargoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    private final CargoFacade cargoFacade;

    @Autowired
    public CargoController(CargoFacade cargoFacade) {
        this.cargoFacade = cargoFacade;
    }

    @GetMapping ("/buscarCargos")
    public ResponseEntity<List<Cargo>> buscarTodos() {
        List<Cargo> cargos = cargoFacade.buscarTodos();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/buscarCargo/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable int id) {
        Cargo cargo = cargoFacade.buscarPorId(id);
        return cargo != null ? ResponseEntity.ok(cargo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cargo> salvar(@RequestBody Cargo cargo) {
        Cargo novoCargo = cargoFacade.salvar(cargo);
        return ResponseEntity.status(201).body(novoCargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable int id, @RequestBody Cargo cargo) {
        Cargo cargoAtualizado = cargoFacade.atualizar(id, cargo);
        return cargoAtualizado != null ? ResponseEntity.ok(cargoAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        boolean apagado = cargoFacade.deletar(id);
        return apagado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
