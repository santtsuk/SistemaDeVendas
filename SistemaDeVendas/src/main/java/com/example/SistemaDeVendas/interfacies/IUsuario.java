package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Usuario;

import java.util.ArrayList;

public interface IUsuario {

    public Usuario buscarPorId(int id);

    public ArrayList<Usuario> buscarTodos();

    public void salvar(int id, String cpf, String nome, String senha, String cargo, String setor);

    public void atualizar(int id, Usuario usuario);

    public void deletar(int id);

}
