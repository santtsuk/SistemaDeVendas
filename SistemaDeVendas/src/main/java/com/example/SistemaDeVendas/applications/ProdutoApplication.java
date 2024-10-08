package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.Produto;
import com.example.SistemaDeVendas.interfacies.IProduto;
import com.example.SistemaDeVendas.repositories.ProdutoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ProdutoApplication implements IProduto{

    private ProdutoRepositoryMySql produtoRepository;

    @Autowired
    public ProdutoApplication(ProdutoRepositoryMySql produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public Produto buscarPorId(int id) {
        return this.produtoRepository.buscarPorId(id);
    }


    public List<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }


    public void salvar(Produto produto) {
        this.produtoRepository.salvar(produto);
    }


    public void atualizar(int id, Produto produto) {
        Produto produtoInDB = this.produtoRepository.buscarPorId(id);

        if (produtoInDB == null)
            return;

        this.produtoRepository.atualizar(id, produto);
    }

    public void deletar(int id) {
        this.produtoRepository.deletar(id);
    }

}