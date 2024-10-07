package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Usuario;

import java.util.List;

public interface IUsuario {

    public Usuario buscarPorId(int id);

    public List<Usuario> buscarTodos();

    public void salvar(Usuario usuario);

    public void atualizar(int id, Usuario usuario);

    public void deletar(int id);

    public void deleteAll();

}