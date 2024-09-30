package com.example.SistemaDeVendas.applications;

import com.example.SistemaDeVendas.entities.TipoPagamento;
import com.example.SistemaDeVendas.interfacies.IProduto;
import com.example.SistemaDeVendas.interfacies.ITipoPagamento;

import java.util.ArrayList;

public class TipoPagamentoApplication {

        private ITipoPagamento tipoPagamentoRepository;


        public TipoPagamentoApplication( ITipoPagamento tipoPagamentoRepository) {
            this.tipoPagamentoRepository = tipoPagamentoRepository;
        }

        public TipoPagamento buscarPorId(int id) {
            return this.tipoPagamentoRepository.buscarPorId(id);
        }


        public ArrayList<TipoPagamento> buscarTodos() {
            return this.tipoPagamentoRepository.buscarTodos();
        }


        public void salvar(int id, String descricao) {
            this.tipoPagamentoRepository.salvar(id, descricao);
        }


        public void atualizar(int id, TipoPagamento tipoRepositoryAtualizado) {
            this.tipoPagamentoRepository.atualizar(id, tipoRepositoryAtualizado);
        }

        public void deletar(int id) {
            this.tipoPagamentoRepository.deletar(id);
        }
}
