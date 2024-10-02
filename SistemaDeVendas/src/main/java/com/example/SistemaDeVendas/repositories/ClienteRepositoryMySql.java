package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.interfacies.ICliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClienteRepositoryMySql implements ICliente {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ClienteRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    public Cliente buscarPorId(int id) {
        return this.entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return entityManager.createQuery("select c from Cliente c ORDER BY c.nome", Cliente.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, Cliente cliente) {
        Cliente clienteInDB = this.entityManager.find(Cliente.class, id);
        if (clienteInDB == null) {
            throw new EntityNotFoundException("Cliente não encontrado com id: " + id);
        }

        clienteInDB.setNome(cliente.getNome());
        clienteInDB.setCpf(cliente.getCpf());
        clienteInDB.setEmail(cliente.getEmail());
        clienteInDB.setEndereco(cliente.getEndereco());
        clienteInDB.setTelefone(cliente.getTelefone());

        this.entityManager.merge(clienteInDB);
    }

    @Override
    @Transactional
    public void deletar(int id) {
        Query query = entityManager.createQuery("delete from Cliente c WHERE c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("delete from Cliente c");
        query.executeUpdate();
    }
}
