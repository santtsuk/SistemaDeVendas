package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Cargo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ICargo {

    public Cargo buscarPorId(int id);

    public ArrayList<Cargo> buscarTodos();

    public void salvar(int id, String nomeCargo, float salario);

    public void atualizar(int id, Cargo cargo);

    public void deletar(int id);

}
