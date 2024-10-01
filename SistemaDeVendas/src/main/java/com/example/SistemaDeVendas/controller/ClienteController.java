package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
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
    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteFacade.salvar(cliente);
        return ResponseEntity.status(201).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteFacade.atualizar(id, cliente);
        return clienteAtualizado != null ? ResponseEntity.ok(clienteAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        boolean apagado = clienteFacade.deletar(id);
        return apagado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
