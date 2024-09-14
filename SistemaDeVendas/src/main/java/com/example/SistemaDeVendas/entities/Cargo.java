package com.example.SistemaDeVendas.entities;

public class Cargo {

    private int id;
    private String nomeCargo;
    private float salario;

    public Cargo(int id, String nomeCargo, float salario) {
        this.id = id;
        this.nomeCargo = nomeCargo;
        this.salario = salario;
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
