package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.facades.ClienteFacade;
import com.example.SistemaDeVendas.facades.DescontoFidelidadeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/descontosfidelidade")
public class DescontoFidelidadeController {

    private DescontoFidelidadeFacade descontoFidelidadeFacade;

    @Autowired
    public DescontoFidelidadeController(DescontoFidelidadeFacade descontoFidelidadeFacade) {
        this.descontoFidelidadeFacade = descontoFidelidadeFacade;
    }

    @GetMapping("/buscarDescontosFidelidades")
    public ResponseEntity<List<DescontoFidelidade>> buscarTodos() {
        List<DescontoFidelidade> descontosFidelidades = descontoFidelidadeFacade.buscarTodos();

        return ResponseEntity.ok(descontosFidelidades);
    }

    @GetMapping("/buscarDescontoFidelidade/{id}")
    public ResponseEntity<DescontoFidelidade> buscarPorId(@PathVariable int id) {
        DescontoFidelidade descontoFidelidade = descontoFidelidadeFacade.buscarPorId(id);

        return ResponseEntity.ok(descontoFidelidade);
    }
    @PostMapping
    public ResponseEntity<DescontoFidelidade> salvar(@RequestBody DescontoFidelidade descontoFidelidade) {
        DescontoFidelidade novoDescontoFidelidade = descontoFidelidadeFacade.salvar(descontoFidelidade);
        return ResponseEntity.status(201).body(novoDescontoFidelidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescontoFidelidade> atualizar(@PathVariable int id, @RequestBody DescontoFidelidade descontoFidelidade) {
        DescontoFidelidade novoDescontoFidelidade = descontoFidelidadeFacade.atualizar(id,descontoFidelidade);
        return novoDescontoFidelidade != null ? ResponseEntity.ok(novoDescontoFidelidade) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        boolean apagado = descontoFidelidadeFacade.deletar(id);
        return apagado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
