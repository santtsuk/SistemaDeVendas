package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.ItemPedido;
import com.example.SistemaDeVendas.interfacies.IItemPedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemPedidoRepositoryMySql implements IItemPedido {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ItemPedidoRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ItemPedido buscarPorId(int id) {
        return this.entityManager.find(ItemPedido.class, id);
    }

    @Override
    public List<ItemPedido> buscarTodos() {
        return entityManager.createQuery("select p from ItemPedido p ORDER BY p.nomeItemPedido", ItemPedido.class).getResultList();
    }

    @Transactional
    @Override
    public void salvar(ItemPedido itemPedido) {
        this.entityManager.persist(itemPedido);
    }

    @Transactional
    @Override
    public void atualizar(int id, ItemPedido itemPedido) {
        ItemPedido itemPedidoInDB = this.entityManager.find(ItemPedido.class, id);

        itemPedidoInDB.setIdPedido(itemPedido.getIdPedido());
        itemPedidoInDB.setIdProduto(itemPedido.getIdProduto());
        itemPedidoInDB.setQuantidade(itemPedido.getQuantidade());
        itemPedidoInDB.setPrecoUnitario(itemPedido.getPrecoUnitario());
        this.entityManager.merge(itemPedidoInDB);
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from ItemPedido i WHERE i.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}