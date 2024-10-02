package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.interfacies.IItemPedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ItemPedidoRepositoryMySql implements IItemPedido {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ItemPedidoRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(ItemPedido itemPedido) {
        this.entityManager.persist(itemPedido);
    }

    @Override
    public ItemPedido buscarPorId(int id) {
        return this.entityManager.find(ItemPedido.class, id);
    }

    @Override
    public List<ItemPedido> buscarTodos() {
        return entityManager.createQuery("select c from ItemPedido c ORDER BY c.nomeItemPedido", ItemPedido.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, ItemPedido itemPedido) {
        ItemPedido itemPedidoInDB = this.entityManager.find(ItemPedido.class, id);
        if (itemPedidoInDB != null) {
            itemPedidoInDB.setNomeItemPedido(itemPedido.getNomeItemPedido());
            itemPedidoInDB.setSalario(itemPedido.getSalario());
            this.entityManager.merge(itemPedidoInDB);
        }
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from ItemPedido c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from ItemPedido c");
        query.executeUpdate();
    }
}