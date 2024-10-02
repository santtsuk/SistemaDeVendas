package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.UsuarioApplication;
import com.example.SistemaDeVendas.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioFacade {
    private UsuarioApplication usuarioApplication;

    @Autowired
    public UsuarioFacade(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public Usuario buscarPorId(int id) {
        return usuarioApplication.buscarPorId(id);
    }

    public List<Usuario> buscarTodos() {
        return usuarioApplication.buscarTodos();
    }

    public void salvar(Usuario usuario) {
        usuarioApplication.salvar(usuario);
    }

    public void atualizar(int id, Usuario usuarioAtualizado) {
        usuarioApplication.atualizar(id, usuarioAtualizado);
    }

    public void deletar(int id) {
        usuarioApplication.deletar(id);
    }
}

