package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "desconto_fidelidade")
public class DescontoFidelidade {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idCliente")
    private Cliente idCliente;
    @Column(name = "valorDesconto")
    private float valorDesconto;
    @Column(name = "dataAplicacao")
    private String dataAplicacao;

    public DescontoFidelidade() {
    }

    public DescontoFidelidade(int id, Cliente idCliente, float valorDesconto, String dataAplicacao) {
        this.id = id;
        this.idCliente = idCliente;
        this.valorDesconto = valorDesconto;
        this.dataAplicacao = dataAplicacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
