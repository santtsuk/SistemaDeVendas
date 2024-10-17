package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_cargo")
    private String nomeCargo;

    @Column(name = "salario")
    private float salario;
    

    public Cargo(String nomeCargo, float salario) {
        this.nomeCargo = nomeCargo;
        this.salario = salario;

    }

    public Cargo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
