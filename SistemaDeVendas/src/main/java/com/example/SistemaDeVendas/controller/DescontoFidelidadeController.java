package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import com.example.SistemaDeVendas.facades.DescontoFidelidadeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/descontofidelidade")
public class DescontoFidelidadeController {

    private DescontoFidelidadeFacade descontoFidelidadeFacade;

    @Autowired
    public DescontoFidelidadeController(DescontoFidelidadeFacade descontoFidelidadeFacade) {
        this.descontoFidelidadeFacade = descontoFidelidadeFacade;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<DescontoFidelidade>> buscarTodos() {
        List<DescontoFidelidade> descontosFidelidades = descontoFidelidadeFacade.buscarTodos();

        return ResponseEntity.ok(descontosFidelidades);
    }

    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<DescontoFidelidade> buscarPorId(@PathVariable int id) {
        DescontoFidelidade descontoFidelidade = descontoFidelidadeFacade.buscarPorId(id);

        return ResponseEntity.ok(descontoFidelidade);
    }
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody DescontoFidelidade descontoFidelidade) {
        descontoFidelidadeFacade.salvar(descontoFidelidade);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescontoFidelidade> atualizar(@PathVariable int id, @RequestBody DescontoFidelidade descontoFidelidade) {
        descontoFidelidadeFacade.atualizar(id, descontoFidelidade);

        return ResponseEntity.ok(descontoFidelidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        descontoFidelidadeFacade.deletar(id);
        return ResponseEntity.ok(null);
    }
}

