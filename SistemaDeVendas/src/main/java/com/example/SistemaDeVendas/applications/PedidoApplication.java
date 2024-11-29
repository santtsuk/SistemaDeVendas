package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.configs.RegraNegocioException;
import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPedido;
import com.example.SistemaDeVendas.repositories.PedidoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.ProdutoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoApplication implements IPedido {

    private final PedidoRepositoryMySql pedidoRepository;
    private  ProdutoRepositoryMySql produtoRepository;


    @Autowired
public PedidoApplication(PedidoRepositoryMySql pedidoRepository, ProdutoRepositoryMySql produtoRepository) {
    this.pedidoRepository = pedidoRepository;
    this.produtoRepository = produtoRepository;
}


    public Pedido buscarPorId(int id) {
        return this.pedidoRepository.buscarPorId(id);
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.buscarTodos();
    }

    public void salvar(Pedido pedido) {
        if (pedido.verificaItemExistente()) {
            throw new RegraNegocioException("O pedido deve ter pelo menos um item associado.");
        }

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
        atualizarCategoria(pedido.getIdCliente());
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



    public void atualizarCategoria(Cliente cliente){
        float totalCompra = totalValorCompra();
        if(totalCompra >=1000){
            cliente.setCategoria(Categorias.BRONZE);
        }
        else if (totalCompra >=3000) {
            cliente.setCategoria(Categorias.PRATA);
        }
        else if (totalCompra >=7000) {
            cliente.setCategoria(Categorias.OURO);
        }
        else if (totalCompra >=10000) {
            cliente.setCategoria(Categorias.DIAMANTE);
        }

    }

    private float totalValorCompra() {
        //criar logica
        return 0;
    }

}