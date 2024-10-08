package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.interfacies.ITipoPagamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TipoPagamentoRepositoryMySql implements ITipoPagamento {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public TipoPagamentoRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(TipoPagamento tipoPagamento) {
        this.entityManager.persist(tipoPagamento);
    }

    @Override
    public TipoPagamento buscarPorId(int id) {
        return this.entityManager.find(TipoPagamento.class, id);
    }

    @Override
    public List<TipoPagamento> buscarTodos() {
        return entityManager.createQuery("select c from TipoPagamento c ORDER BY c.descricao", TipoPagamento.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, TipoPagamento tipoPagamento) {
        TipoPagamento tipoPagamentoInDB = this.entityManager.find(TipoPagamento.class, id);

        tipoPagamentoInDB.setDescricao(tipoPagamento.getDescricao());
        this.entityManager.merge(tipoPagamentoInDB);
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from TipoPagamento c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}