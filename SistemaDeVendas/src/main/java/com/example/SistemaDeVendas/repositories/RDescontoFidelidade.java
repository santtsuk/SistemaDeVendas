package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.entities.Cliente;
import com.example.SistemaDeVendas.entities.DescontoFidelidade;
import com.example.SistemaDeVendas.interfacies.IDescontoFidelidade;

import java.util.ArrayList;

public class RDescontoFidelidade implements IDescontoFidelidade {

    ArrayList<DescontoFidelidade> descontoFidelidades = new ArrayList<>();

    @Override
    public DescontoFidelidade buscarPorId(int id) {

        DescontoFidelidade buscarDescontoFidelidade = descontoFidelidades.stream().filter(p -> p.getId() == id).findFirst().get();

        return buscarDescontoFidelidade;
    }

    @Override
    public ArrayList<DescontoFidelidade> buscarTodos() {

        return descontoFidelidades;
    }

    @Override
    public void salvar(int id, Cliente idCliente, float valorDesconto, String dataAplicacao) {

        DescontoFidelidade descontoFidelidadeNovo = new DescontoFidelidade(id, idCliente, valorDesconto, dataAplicacao);
        descontoFidelidades.add(descontoFidelidadeNovo);
    }

    @Override
    public void atualizar(int id, DescontoFidelidade descontoFidelidade) {

        DescontoFidelidade descontoFidelidadeUpdate = buscarPorId(id);

        descontoFidelidadeUpdate.setIdCliente(descontoFidelidade.getIdCliente());
        descontoFidelidadeUpdate.setValorDesconto(descontoFidelidade.getValorDesconto());
        descontoFidelidadeUpdate.setDataAplicacao(descontoFidelidade.getDataAplicacao());
    }

    @Override
    public void deletar(int id) {

        descontoFidelidades.removeIf(delete -> delete.getId() == id);
    }
}