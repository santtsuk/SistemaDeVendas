package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.facades.FuncionarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FuncionarioController {
    private final FuncionarioFacade funcionarioFacade;

    @Autowired
    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    @GetMapping("/buscarFuncionario")
    public ResponseEntity<List<Funcionario>> buscarTodos() {
        List<Funcionario> funcionarios = funcionarioFacade.buscarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/buscarFuncionarios/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable int id) {
        Funcionario funcionario = funcionarioFacade.buscarPorId(id);
        return funcionario != null ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Funcionario funcionario) {
        funcionarioFacade.salvar(funcionario);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable int id, @RequestBody Funcionario funcionario) {
        funcionarioFacade.atualizar(id, funcionario);

        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        funcionarioFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}
