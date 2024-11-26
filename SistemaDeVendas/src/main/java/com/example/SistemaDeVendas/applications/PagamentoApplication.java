package com.example.SistemaDeVendas.applications;


import com.example.SistemaDeVendas.configs.RegraNegocioException;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.entities.Pagamento;
import com.example.SistemaDeVendas.entities.Pedido;
import com.example.SistemaDeVendas.interfacies.IPagamento;
import com.example.SistemaDeVendas.repositories.DescontoFidelidadeRepositoryMySql;
import com.example.SistemaDeVendas.repositories.PagamentoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.PedidoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoApplication implements IPagamento {

    private final PagamentoRepositoryMySql pagamentoRepository;
    private final DescontoFidelidadeRepositoryMySql descontoFidelidadeRepository;
    private final PedidoRepositoryMySql pedidoRepository;

    @Autowired
    public PagamentoApplication(PagamentoRepositoryMySql pagamentoRepository,
                                DescontoFidelidadeRepositoryMySql descontoFidelidadeRepository,
                                PedidoRepositoryMySql pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.descontoFidelidadeRepository = descontoFidelidadeRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Pagamento buscarPorId(int id) {
        return this.pagamentoRepository.buscarPorId(id);
    }

    public List<Pagamento> buscarTodos() {
        return this.pagamentoRepository.buscarTodos();
    }

    public void salvar(Pagamento pagamento) {
        Pedido pedido = pagamento.getPedido();

        if (pagamento.getDescontoFidelidade() != null) {
            DescontoFidelidade desconto = descontoFidelidadeRepository.buscarPorId(pagamento.getDescontoFidelidade().getId());
            if (desconto == null) {
                throw new RegraNegocioException("Desconto não encontrado.");
            }

            if (desconto.getDataAplicacao().isBefore(LocalDate.now())) {
                throw new RegraNegocioException("Desconto expirado.");
            }

            float valorDesconto = desconto.getValorDesconto();
            float valorTotalAtual = pedido.getValorTotal();

            
            if (valorDesconto > 0) {
                throw new RegraNegocioException("O valor do desconto não pode ser maior que o total do pedido.");
            }


            float  novoValorTotal = valorTotalAtual - valorDesconto;
            pedido.setValorTotal(novoValorTotal);
            pedidoRepository.atualizar(pedido.getId(), pedido);
        }
        this.pagamentoRepository.salvar(pagamento);

        
        pedido.atualizarStatusPagamento();
        this.pedidoRepository.atualizar(pedido.getId(), pedido);
    }

    public void atualizar(int id, Pagamento pagamento) {
        Pagamento pagamentoInDB = this.pagamentoRepository.buscarPorId(id);

        if (pagamentoInDB == null) {
            throw new RegraNegocioException("Pagamento não encontrado.");
        }

        this.pagamentoRepository.atualizar(id, pagamento);
    }

    public void deletar(int id) {
        Pagamento pagamentoInDB = this.pagamentoRepository.buscarPorId(id);

        if (pagamentoInDB == null) {
            throw new RegraNegocioException("Pagamento não encontrado.");
        }

        this.pagamentoRepository.deletar(id);
    }
}
