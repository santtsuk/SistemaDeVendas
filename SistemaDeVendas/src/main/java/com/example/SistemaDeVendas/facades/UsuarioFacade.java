package com.example.SistemaDeVendas.facades;

import com.example.SistemaDeVendas.applications.UsuarioApplication;
import com.example.SistemaDeVendas.entities.Usuario;

import java.util.ArrayList;

public class UsuarioFacade {
    private UsuarioApplication usuarioApplication;


    public UsuarioFacade(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public Usuario buscarPorId(int id) {
        return this.usuarioApplication.buscarPorId(id);
    }

    public ArrayList<Usuario> buscarTodos() {
        return this.usuarioApplication.buscarTodos();
    }

    public void salvar(int id, String cpf, String nome, String senha, String cargo, String setor) {
        this.usuarioApplication.salvar(id, cpf, nome, senha, cargo, setor);
    }

    public void atualizar(int id, Usuario usuarioAtualizado) {
        this.usuarioApplication.atualizar(id, usuarioAtualizado);
    }

    public void deletar(int id) {
        this.usuarioApplication.deletar(id);
    }

}

