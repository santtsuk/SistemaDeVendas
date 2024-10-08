package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;

import java.util.ArrayList;
import java.util.List;

public interface IDescontoFidelidade {

    public DescontoFidelidade buscarPorId(int id);

    public List<DescontoFidelidade> buscarTodos();

    public void salvar(DescontoFidelidade descontoFidelidade);

    public void atualizar(int id, DescontoFidelidade descontoFidelidade);

    public void deletar(int id);

}
