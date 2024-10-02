package com.example.SistemaDeVendas.controller;

import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.facades.UsuarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    private UsuarioFacade usuarioFacade;

    @Autowired
    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping("/buscarUsuario")
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> usuarios = usuarioFacade.buscarTodos();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/buscarUsuario/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id) {
        Usuario usuario = usuarioFacade.buscarPorId(id);

        return ResponseEntity.ok(usuario);
    }
}
