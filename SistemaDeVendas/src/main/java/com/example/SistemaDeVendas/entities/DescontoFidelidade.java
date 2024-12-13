package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "desconto_fidelidade")
public class DescontoFidelidade {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;

    @Column(name = "valor_desconto")
    private float valorDesconto;

    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;

    @Column(name = "data_expirar")
    private LocalDate dataExpirar;

    @OneToOne(mappedBy = "descontoFidelidade")
    private Pedido pedido;

    public DescontoFidelidade(Cliente cliente, float valorDesconto,LocalDate dataAplicacao,LocalDate dataExpirar) {
        this.cliente = cliente;
        this.dataAplicacao = dataAplicacao;
        this.dataExpirar = dataExpirar;
    }

    public DescontoFidelidade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public void setPedidoo(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDate getDataExpirar() {return dataExpirar;}

    public void setDataExpirar(LocalDate dataExpirar) {this.dataExpirar = dataExpirar;}

    public boolean verificarVencimento() {
        return this.dataExpirar.isBefore(LocalDate.now());
    }
    public boolean verificarValorDesconto(float valorTotal){
        return valorTotal < valorDesconto ;
    }

    public float valorDesconto(float valorTotal){

        if (cliente.getCategoria() == Categorias.BRONZE) {
            return this.valorDesconto = (float) (valorTotal * 0.02);
        }
        else if (cliente.getCategoria() == Categorias.PRATA) {
            return this.valorDesconto = (float) (valorTotal * 0.05);
        }
        else if (cliente.getCategoria() == Categorias.OURO) {
            return this.valorDesconto = (float) (valorTotal * 0.10);
        }
        else if (cliente.getCategoria() == Categorias.DIAMANTE) {
            return this.valorDesconto = (float) (valorTotal * 0.15);
        }
        return 0;
    }
}
