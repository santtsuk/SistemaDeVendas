package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.interfacies.IUsuario;

import java.util.ArrayList;

public class UsuarioRepository implements IUsuario {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario buscarPorId(int id) {

        Usuario buscarUsuario = usuarios.stream().filter(p -> p.getId() == id).findFirst().get();
        return buscarUsuario;
    }

    @Override
    public ArrayList<Usuario> buscarTodos() {

        return usuarios;
    }

    @Override
    public void salvar(int id, String cpf, String nome, String senha, String cargo, String setor) {

        Usuario usuarioNovo = new Usuario(id, cpf, nome, senha, cargo, setor);
        usuarios.add(usuarioNovo);
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
}