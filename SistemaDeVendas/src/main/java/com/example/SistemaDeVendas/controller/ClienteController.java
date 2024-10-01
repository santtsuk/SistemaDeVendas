package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {

    private ClienteFacade clienteFacade;



    @Autowired
    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @GetMapping("/buscarClientes")
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> clientes = clienteFacade.buscarTodos();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/buscarClientes/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        Cliente cliente = clienteFacade.buscarPorId(id);

        return ResponseEntity.ok(cliente);
    }

}
