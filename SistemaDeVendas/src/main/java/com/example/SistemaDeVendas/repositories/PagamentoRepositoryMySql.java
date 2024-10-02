package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.interfacies.IPagamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public void salvar(int id, Pedido idPedido, TipoPagamento idPagamento, float valor) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(id);
        pagamento.setPedido(idPedido);
        pagamento.setTipoPagamento(idPagamento);
        pagamento.setValor(valor);
        this.entityManager.persist(pagamento);
    }

    @Override
    public Pagamento buscarPorId(int id) {
        return this.entityManager.find(Pagamento.class, id);
    }

    @Override
    public ArrayList<Pagamento> buscarTodos() {
        List<Pagamento> resultList = entityManager.createQuery("select c from Pagamento c ORDER BY c.nomePagamento", Pagamento.class).getResultList();
        return new ArrayList<>(resultList);  // Convertendo para ArrayList
    }

    @Transactional
    @Override
    public void atualizar(int id, Pagamento pagamento) {
        Pagamento pagamentoInDB = this.entityManager.find(Pagamento.class, id);
        if (pagamentoInDB != null) {
            pagamentoInDB.setNomePagamento(pagamento.getNomePagamento());
            pagamentoInDB.setSalario(pagamento.getSalario());
            this.entityManager.merge(pagamentoInDB);
        }
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from Pagamento c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Pagamento c");
        query.executeUpdate();
    }
}
