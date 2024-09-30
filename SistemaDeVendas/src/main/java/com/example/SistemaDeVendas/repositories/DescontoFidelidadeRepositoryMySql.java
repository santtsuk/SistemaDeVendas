package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.interfacies.IDescontoFidelidade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DescontoFidelidadeRepositoryMySql implements IDescontoFidelidade {

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
        return this.entityManager.find(DescontoFidelidade.class,id);
    }

    @Override
    public List<DescontoFidelidade> buscarTodos() {
        return entityManager.createQuery("select s from DescontoFidelidade s ORDER BY s.dataAplicacao",DescontoFidelidade.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, DescontoFidelidade descontoFidelidade) {
        DescontoFidelidade descontoFidelidadeInDB = this.entityManager.find(DescontoFidelidade.class,id);

        descontoFidelidadeInDB.setIdCliente(descontoFidelidade.getIdCliente());
        descontoFidelidadeInDB.setValorDesconto(descontoFidelidade.getValorDesconto());
        descontoFidelidadeInDB.setDataAplicacao(descontoFidelidade.getDataAplicacao());

        this.entityManager.merge(descontoFidelidadeInDB);
    }
    @Override
    @Transactional
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from DescontoFidelidade s WHERE s.id = :id");

        query.setParameter("id" ,id);

        query.executeUpdate();
    }
    @Transactional
    public void deleteAll() {
        Query query = entityManager
                .createQuery("delete from DescontoFidelidade s");
        query.executeUpdate();
    }
}
