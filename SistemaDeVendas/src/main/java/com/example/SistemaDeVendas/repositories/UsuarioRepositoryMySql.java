package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Usuario;
import com.example.SistemaDeVendas.interfacies.IUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioRepositoryMySql implements IUsuario {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UsuarioRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(Usuario usuario) {
        this.entityManager.persist(usuario);
    }

    @Override
    public Usuario buscarPorId(int id) {
        return this.entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return entityManager.createQuery("select c from Usuario c ORDER BY c.nomeUsuario", Usuario.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, Usuario usuario) {
        Usuario usuarioInDB = this.entityManager.find(Usuario.class, id);

        usuarioInDB.setCpf(usuario.getCpf());
        usuarioInDB.setNome(usuario.getNome());
        usuarioInDB.setSenha(usuario.getSenha());
        usuarioInDB.setCargo(usuario.getCargo());
        usuarioInDB.setSetor(usuario.getSetor());

        this.entityManager.merge(usuarioInDB);
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from Usuario c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Usuario c");
        query.executeUpdate();
    }
}

