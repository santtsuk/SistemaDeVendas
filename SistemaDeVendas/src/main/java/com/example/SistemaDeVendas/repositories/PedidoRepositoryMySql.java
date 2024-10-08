package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.interfacies.IPedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PedidoRepositoryMySql implements IPedido {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public PedidoRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(Pedido pedido) {
        this.entityManager.persist(pedido);
    }

    @Override
    public Pedido buscarPorId(int id) {
        return this.entityManager.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> buscarTodos() {
        return entityManager.createQuery("select c from Pedido c ORDER BY c.dataPedido", Pedido.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, Pedido pedido) {
        Pedido pedidoInDB = this.entityManager.find(Pedido.class, id);
        if (pedidoInDB != null) {

            pedidoInDB.setDataPedido(pedido.getDataPedido());
            pedidoInDB.setIdCliente(pedido.getIdCliente());
            pedidoInDB.setValorTotal(pedido.getValorTotal());
            pedidoInDB.setIdPagamento(pedido.getIdPagamento());
            pedidoInDB.setIdUsuario(pedido.getIdUsuario());

            this.entityManager.merge(pedidoInDB);
        }
    }

    @Transactional
    @Override
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from Produto c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
