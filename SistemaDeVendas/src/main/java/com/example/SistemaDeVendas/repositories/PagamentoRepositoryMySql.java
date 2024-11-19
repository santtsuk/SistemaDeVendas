package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.interfacies.IPagamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PagamentoRepositoryMySql implements IPagamento {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PagamentoRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(Pagamento pagamento) {
        this.entityManager.persist(pagamento);
    }

    public Pagamento buscarPorId(int id) {
        return this.entityManager.find(Pagamento.class, id);
    }

    @Override
    public List<Pagamento> buscarTodos() {
        return entityManager.createQuery("select p from Pagamento p ORDER BY p.idPedido", Pagamento.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, Pagamento pagamento) {
        Pagamento pagamentoInDB = this.entityManager.find(Pagamento.class, id);

        pagamentoInDB.setIdPagamento(pagamento.getIdPagamento());
        pagamentoInDB.setValor(pagamento.getValor());
        this.entityManager.merge(pagamentoInDB);
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from Pagamento p WHERE p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Pagamento p");
        query.executeUpdate();
    }
}