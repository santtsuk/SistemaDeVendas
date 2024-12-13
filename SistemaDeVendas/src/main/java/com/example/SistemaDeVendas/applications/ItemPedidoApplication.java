package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.configs.RegraNegocioException;
import com.example.SistemaDeVendas.controller.CargoController;
import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IItemPedido;
import com.example.SistemaDeVendas.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemPedidoApplication implements IItemPedido {

    private ItemPedidoRepositoryMySql itemPedidoRepository;
    private PedidoRepositoryMySql pedidoRepository;
    private ProdutoRepositoryMySql produtoRepository;
    private ClienteRepositoryMySql clienteRepository;
    private DescontoFidelidadeRepositoryMySql descontoFidelidadeRepository;

    @Autowired
    public ItemPedidoApplication(ItemPedidoRepositoryMySql itemPedidoRepository,PedidoRepositoryMySql pedidoRepository,ProdutoRepositoryMySql produtoRepository,ClienteRepositoryMySql clienteRepository,DescontoFidelidadeRepositoryMySql descontoFidelidadeRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.descontoFidelidadeRepository = descontoFidelidadeRepository;
    }

    public ItemPedido buscarPorId(int id) {
        return this.itemPedidoRepository.buscarPorId(id);
    }

    public List<ItemPedido> buscarTodos() {
        return this.itemPedidoRepository.buscarTodos();
    }

    @Transactional
    public void salvar(ItemPedido itemPedido) {

            if (itemPedido.getIdProduto() == null) {
                throw new RegraNegocioException("Produto não encontrado para o item do pedido.");
            }


            Produto produto = produtoRepository.buscarPorId(itemPedido.getIdProduto().getId());

            if (produto == null) {
                throw new RegraNegocioException("Produto não encontrado.");
            }

            if (produto.verificarEstoque(itemPedido.getQuantidade())) {
                throw new RegraNegocioException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            produto.baixarEstoque(itemPedido.getQuantidade());

            produtoRepository.atualizar(produto.getId(), produto);

        this.itemPedidoRepository.salvar(itemPedido);
        atualizarValorTotalPedido(itemPedido.getIdPedido().id());
    }

    public void atualizar(int id, ItemPedido itemPedido) {
        ItemPedido ItemPedidoInDB = this.itemPedidoRepository.buscarPorId(id);

        if (ItemPedidoInDB == null)
            return;

        this.itemPedidoRepository.atualizar(id, itemPedido);
    }

    public void deletar(int id) {
        ItemPedido itemPedido = itemPedidoRepository.buscarPorId(id);
        this.itemPedidoRepository.deletar(id);
        atualizarValorTotalPedido(itemPedido.getIdPedido().id());
    }
    public void atualizarValorTotalPedido(int pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new RegraNegocioException("Pedido não encontrado.");
        }

        // Calcula o valor total do pedido
        pedido.calcularValorTotal();

        // Verifica e aplica desconto fidelidade, se houver
        if (pedido.getDescontoFidelidade() != null) {
            DescontoFidelidade descontoFidelidade = descontoFidelidadeRepository.buscarPorId(pedido.getDescontoFidelidade().getId());

            if (descontoFidelidade == null) {
                throw new RegraNegocioException("Desconto fidelidade não encontrado.");
            }

            // Calcula e aplica o desconto
            float valorDesconto = descontoFidelidade.valorDesconto(pedido.getValorTotal());
            pedido.aplicarDesconto(valorDesconto);

            // Atualiza o desconto fidelidade no repositório
            descontoFidelidadeRepository.atualizar(descontoFidelidade.getId(), descontoFidelidade);
        }

        // Atualiza o status de pagamento do pedido
        pedido.atualizarStatusPagamento();
        pedidoRepository.atualizar(pedido.getId(), pedido);

        // Verifica e atualiza a categoria do cliente
        if (pedido.getIdCliente() == null) {
            throw new RegraNegocioException("Pedido não possui um cliente associado.");
        }

        Cliente cliente = clienteRepository.buscarPorId(pedido.getIdCliente().getId());
        if (cliente == null) {
            throw new RegraNegocioException("Cliente associado ao pedido não foi encontrado.");
        }

        cliente.atualizarCategoria();
        clienteRepository.atualizar(cliente.getId(), cliente);
    }


}