package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.configs.RegraNegocioException;
import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPedido;
import com.example.SistemaDeVendas.repositories.ClienteRepositoryMySql;
import com.example.SistemaDeVendas.repositories.PedidoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.ProdutoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidoApplication implements IPedido {

    private final PedidoRepositoryMySql pedidoRepository;
    private  ProdutoRepositoryMySql produtoRepository;
    private ClienteRepositoryMySql clienteRepository;


    @Autowired
public PedidoApplication(PedidoRepositoryMySql pedidoRepository, ProdutoRepositoryMySql produtoRepository,ClienteRepositoryMySql clienteRepository) {
    this.pedidoRepository = pedidoRepository;
    this.produtoRepository = produtoRepository;
    this.clienteRepository = clienteRepository;
}


    public Pedido buscarPorId(int id) {
        return this.pedidoRepository.buscarPorId(id);
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.buscarTodos();
    }

    public void salvar(Pedido pedido) {

        if (pedido.getItemPedidos() == null) {
            pedido.setItemPedidos(new ArrayList<>());
        }

        for (ItemPedido item : pedido.getItemPedidos()) {
            if (item.getIdProduto() == null) {
                throw new RegraNegocioException("Produto não encontrado para o item do pedido.");
            }

            Produto produto = produtoRepository.buscarPorId(item.getIdProduto().getId());

            if (produto == null) {
                throw new RegraNegocioException("Produto não encontrado.");
            }

            if (produto.verificarEstoque(item.getQuantidade())) {
                throw new RegraNegocioException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            produto.baixarEstoque(item.getQuantidade());

            produtoRepository.atualizar(produto.getId(), produto);
        }


        pedido.calcularValorTotal();
        pedido.atualizarStatusPagamento();
        this.pedidoRepository.salvar(pedido);
    }

    public void atualizar(int id, Pedido pedido) {
        Pedido pedidoInDB = this.pedidoRepository.buscarPorId(id);

        if (pedidoInDB == null)
            return;

        this.pedidoRepository.atualizar(id, pedido);
    }

    public void deletar(int id) {
        this.pedidoRepository.deletar(id);
    }



}