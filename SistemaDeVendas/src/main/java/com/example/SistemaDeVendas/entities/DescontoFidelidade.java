package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "desconto_fidelidade")
public class DescontoFidelidade {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_Cliente")
    private int idCliente;
    @Column(name = "valor_Desconto")
    private float valorDesconto;
    @Column(name = "data_Aplicacao")
    private String dataAplicacao;


    public DescontoFidelidade(int id, int idCliente, float valorDesconto, String dataAplicacao) {
        this.id = id;
        this.idCliente = idCliente;
        this.valorDesconto = valorDesconto;
        this.dataAplicacao = dataAplicacao;
    }

    public DescontoFidelidade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
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
