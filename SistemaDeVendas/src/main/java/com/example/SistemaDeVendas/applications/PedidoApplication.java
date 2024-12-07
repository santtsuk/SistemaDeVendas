package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.configs.RegraNegocioException;
import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPedido;
import com.example.SistemaDeVendas.repositories.ClienteRepositoryMySql;
import com.example.SistemaDeVendas.repositories.PedidoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.ProdutoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

        for (ItemPedido item : pedido.getItemPedidos()) {
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
        this.pedidoRepository.salvar(pedido);


        Cliente cliente = clienteRepository.buscarPorId(pedido.getIdCliente().getId());

        if (cliente != null) {
            cliente.atualizarCategoria();
        } else {

            System.out.println("Cliente não encontrado");
        }

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