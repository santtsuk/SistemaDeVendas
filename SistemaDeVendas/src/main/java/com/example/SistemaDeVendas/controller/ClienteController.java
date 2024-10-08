package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteFacade clienteFacade;



    @Autowired
    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @GetMapping("//buscarTodos")
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> clientes = clienteFacade.buscarTodos();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        Cliente cliente = clienteFacade.buscarPorId(id);

        return ResponseEntity.ok(cliente);
    }
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Cliente cliente) {
        clienteFacade.salvar(cliente);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        clienteFacade.atualizar(id, cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        clienteFacade.deletar(id);
        return ResponseEntity.ok(null);
    }

}
