package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ClienteController {

    private ClienteFacade clienteFacade;

    public void inicializarProdutos() {
        clienteFacade.salvar(1,"jorge","123456789","75984623345","jorge@gmail.com","rua 5,casa 65");
    }

    @Autowired
    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
        inicializarProdutos();
    }

    @GetMapping("/buscarClientes")
    public ResponseEntity<ArrayList<Cliente>> buscarTodos() {
        ArrayList<Cliente> clientes = clienteFacade.buscarTodos();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/buscarClientes/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        Cliente cliente = clienteFacade.buscarPorId(id);

        return ResponseEntity.ok(cliente);
    }

}
