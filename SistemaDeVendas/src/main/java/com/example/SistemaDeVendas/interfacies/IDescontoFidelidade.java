package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;

import java.util.ArrayList;

public interface IDescontoFidelidade {

    public DescontoFidelidade buscarPorId(int id);

    public ArrayList<DescontoFidelidade> buscarTodos();

    public void salvar(int id, Cliente idCliente, float valorDesconto, String dataAplicacao);

    public void atualizar(int id, DescontoFidelidade descontoFidelidade);

    public void deletar(int id);

}
