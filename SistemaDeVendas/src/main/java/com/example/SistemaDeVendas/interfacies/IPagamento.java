package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.*;

import java.util.List;

public interface IPagamento {

    public Pagamento buscarPorId(int id);

    public List<Pagamento> buscarTodos();

    public void salvar(Pagamento pagamento);

    public void atualizar(int id, Pagamento pagamento);

    public void deletar(int id);
}