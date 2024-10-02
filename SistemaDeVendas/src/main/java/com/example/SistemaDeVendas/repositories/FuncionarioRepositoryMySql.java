package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Funcionario;
import com.example.SistemaDeVendas.interfacies.IFuncionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FuncionarioRepositoryMySql implements IFuncionario {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public FuncionarioRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(Funcionario funcionario) {
        this.entityManager.persist(funcionario);
    }

    @Override
    public Funcionario buscarPorId(int id) {
        return this.entityManager.find(Funcionario.class, id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return entityManager.createQuery("select c from Funcionario c ORDER BY c.nomeFuncionario", Funcionario.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, Funcionario funcionario) {
        Funcionario funcionarioInDB = this.entityManager.find(Funcionario.class, id);
        if (funcionarioInDB != null) {
            funcionarioInDB.setNomeFuncionario(funcionario.getNomeFuncionario());
            funcionarioInDB.setSalario(funcionario.getSalario()); // Corrigido
            this.entityManager.merge(funcionarioInDB);
        }
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from Funcionario c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Funcionario c");
        query.executeUpdate();
    }
}