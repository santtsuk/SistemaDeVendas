package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.facades.FuncionarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class FuncionarioController {
    private FuncionarioFacade funcionarioFacade;

    public void inicializarProdutos() {
        funcionarioFacade.salvar(1,"auxiliar Administrativo",1412);
    }

    @Autowired
    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
        inicializarProdutos();
    }

    @GetMapping("/buscarFuncionario")
    public ResponseEntity<ArrayList<Funcionario>> buscarTodos() {
        ArrayList<Funcionario> funcionarios = funcionarioFacade.buscarTodos();

        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/buscarProduto/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable int id) {
        Funcionario funcionario = funcionarioFacade.buscarPorId(id);

        return ResponseEntity.ok(funcionario);
    }
}
