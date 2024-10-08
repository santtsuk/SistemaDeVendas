package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.interfacies.ITipoPagamento;
import com.example.SistemaDeVendas.repositories.TipoPagamentoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagamentoApplication implements ITipoPagamento{

    private TipoPagamentoRepositoryMySql tipoPagamentoRepository;

    @Autowired
    public TipoPagamentoApplication(TipoPagamentoRepositoryMySql tipoPagamentoRepository) {
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }


    public TipoPagamento buscarPorId(int id) {
        return this.tipoPagamentoRepository.buscarPorId(id);
    }


    public List<TipoPagamento> buscarTodos() {
        return this.tipoPagamentoRepository.buscarTodos();
    }


    public void salvar(TipoPagamento tipoPagamento) {
        this.tipoPagamentoRepository.salvar(tipoPagamento);
    }


    public void atualizar(int id, TipoPagamento tipoPagamento) {
        TipoPagamento tipoPagamentoInDB = this.tipoPagamentoRepository.buscarPorId(id);

        if (tipoPagamentoInDB == null)
            return;

        this.tipoPagamentoRepository.atualizar(id, tipoPagamento);
    }

    public void deletar(int id) {
        this.tipoPagamentoRepository.deletar(id);
    }

}
