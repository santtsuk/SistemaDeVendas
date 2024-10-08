package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.*;
import com.example.SistemaDeVendas.interfacies.IPagamento;
import com.example.SistemaDeVendas.repositories.CargoRepositoryMySql;
import com.example.SistemaDeVendas.repositories.PagamentoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoApplication implements IPagamento {

    private PagamentoRepositoryMySql pagamentoRepository;

    @Autowired
    public PagamentoApplication(PagamentoRepositoryMySql pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento buscarPorId(int id) {
        return this.pagamentoRepository.buscarPorId(id);
    }

    public List<Pagamento> buscarTodos() {
        return this.pagamentoRepository.buscarTodos();
    }

    public void salvar(Pagamento pagamento) {
        this.pagamentoRepository.salvar(pagamento);
    }

    public void atualizar(int id, Pagamento pagamento) {
        Pagamento pagamentoInDB = this.pagamentoRepository.buscarPorId(id);

        if (pagamentoInDB == null)
            return;

        this.pagamentoRepository.atualizar(id, pagamento);
    }

    public void deletar(int id) {
        this.pagamentoRepository.deletar(id);
    }
}