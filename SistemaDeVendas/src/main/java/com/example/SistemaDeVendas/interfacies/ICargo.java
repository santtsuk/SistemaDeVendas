package com.example.SistemaDeVendas.interfacies;

import com.example.SistemaDeVendas.entities.Cargo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICargo {

    public Cargo buscarPorId(int id);

    public List<Cargo> buscarTodos();

    public void salvar(Cargo cargo);

    public void atualizar(int id, Cargo cargo);

    public void deletar(int id);
}
