package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.interfacies.IUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements IUsuario {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario buscarPorId(int id) {

        Usuario buscarUsuario = usuarios.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarUsuario;
    }

    @Override
    public List<Usuario> buscarTodos() {

        return usuarios;
    }

    @Override
    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void atualizar(int id, Usuario usuario) {

        Usuario usuarioUpdate = buscarPorId(id);

        usuarioUpdate.setCpf(usuario.getCpf());
        usuarioUpdate.setNome(usuario.getNome());
        usuarioUpdate.setSenha(usuario.getSenha());
        usuarioUpdate.setCargo(usuario.getCargo());
        usuarioUpdate.setSetor(usuario.getSetor());
    }

    @Override
    public void deletar(int id) {

        usuarios.removeIf(delete -> delete.getId() == id);
    }

    public void deletAll(){

    };
}