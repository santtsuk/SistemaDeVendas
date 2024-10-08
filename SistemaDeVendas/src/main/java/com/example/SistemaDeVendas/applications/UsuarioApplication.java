package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.interfacies.IUsuario;
import com.example.SistemaDeVendas.repositories.UsuarioRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioApplication implements IUsuario {

    private UsuarioRepositoryMySql usuarioRepository;

    @Autowired
    public UsuarioApplication(UsuarioRepositoryMySql usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorId(int id) {
        return this.usuarioRepository.buscarPorId(id);
    }

    public List<Usuario> buscarTodos() {
        return this.usuarioRepository.buscarTodos();
    }

    public void salvar(Usuario usuario) {
        this.usuarioRepository.salvar(usuario);
    }

    public void atualizar(int id, Usuario usuario) {
        Usuario usuarioInDB = this.usuarioRepository.buscarPorId(id);

        if (usuarioInDB == null)
            return;
        this.usuarioRepository.atualizar(id, usuario);
    }

    public void deletar(int id) {
        this.usuarioRepository.deletar(id);
    }
}