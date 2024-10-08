package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.interfacies.IProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProdutoRepositoryMySql implements IProduto {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public ProdutoRepositoryMySql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void salvar(Produto produto) {
        this.entityManager.persist(produto);
    }

    @Override
    public Produto buscarPorId(int id) {
        return this.entityManager.find(Produto.class, id);
    }

    @Override
    public List<Produto> buscarTodos() {
        return entityManager.createQuery("select c from Produto c ORDER BY c.nome", Produto.class).getResultList();
    }

    @Transactional
    @Override
    public void atualizar(int id, Produto produto) {
        Produto produtoInDB = this.entityManager.find(Produto.class, id);
        if (produtoInDB != null) {

            produtoInDB.setCodigoBarras(produto.getCodigoBarras());
            produtoInDB.setNome(produto.getNome());
            produtoInDB.setDescricao(produto.getDescricao());
            produtoInDB.setPreco(produto.getPreco());
            produtoInDB.setEstoque(produto.getEstoque());
            produtoInDB.setMinEstoque(produto.getMinEstoque());

            this.entityManager.merge(produtoInDB);
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
