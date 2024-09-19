package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.interfacies.IUsuario;

import java.util.ArrayList;

public class UsuarioApplication {

    private IUsuario usuarioRepository;


    public UsuarioApplication( IUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorId(int id) {
        return this.usuarioRepository.buscarPorId(id);
    }

    public ArrayList<Usuario> buscarTodos() {
        return this.usuarioRepository.buscarTodos();
    }

    public void salvar(int id, String cpf, String nome, String senha, String cargo, String setor) {
        this.usuarioRepository.salvar(id, cpf, nome, senha, cargo, setor);
    }

    public void atualizar(int id, Usuario usuarioAtualizado) {
        this.usuarioRepository.atualizar(id, usuarioAtualizado);
    }

    public void deletar(int id) {
        this.usuarioRepository.deletar(id);
    }
}
