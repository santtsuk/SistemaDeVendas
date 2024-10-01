package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.interfacies.IDescontoFidelidade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DescontoFidelidadeRepositoryMySql implements IDescontoFidelidade {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public DescontoFidelidadeRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(DescontoFidelidade descontoFidelidade) {
        this.entityManager.persist(descontoFidelidade);
    }

    @Override
    public DescontoFidelidade buscarPorId(int id) {
        return this.entityManager.find(DescontoFidelidade.class, id);
    }

    @Override
    public List<DescontoFidelidade> buscarTodos() {
        return entityManager.createQuery("select d from DescontoFidelidade d ORDER BY d.dataAplicacao", DescontoFidelidade.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, DescontoFidelidade descontoFidelidade) {
        DescontoFidelidade descontoFidelidadeInDB = this.entityManager.find(DescontoFidelidade.class, id);
        if (descontoFidelidadeInDB == null) {
            throw new EntityNotFoundException("DescontoFidelidade não encontrado com id: " + id);
        }

        descontoFidelidadeInDB.setIdCliente(descontoFidelidade.getIdCliente());
        descontoFidelidadeInDB.setValorDesconto(descontoFidelidade.getValorDesconto());
        descontoFidelidadeInDB.setDataAplicacao(descontoFidelidade.getDataAplicacao());

        this.entityManager.merge(descontoFidelidadeInDB);
    }

    @Override
    @Transactional
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from DescontoFidelidade d WHERE d.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from DescontoFidelidade d");
        query.executeUpdate();
    }
}
