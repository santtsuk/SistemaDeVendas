package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf" ,unique = true)
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "endereco")
    private String endereco;

    @Enumerated(EnumType.STRING)
    @Column (name = "categoria")
    private Categorias categoria;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Pedido> pedidos  = new ArrayList<>();

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<DescontoFidelidade> descontoFidelidades  = new ArrayList<>();

    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.categoria = Categorias.SEM_CATEGORIA;

    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Categorias getCategoria() {return categoria;}

    public void setCategoria(Categorias categoria) {this.categoria = categoria;}

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setDescontoFidelidades(List<DescontoFidelidade> descontoFidelidades) {
        this.descontoFidelidades = descontoFidelidades;
    }

    private float totalValorCompra() {

        if(this.pedidos == null || this.pedidos.isEmpty()){
            return 0f;
        }

        LocalDate dataLimite = LocalDate.now().minusDays(90);
        return pedidos.stream()
                .filter(pedido -> pedido.getDataPedido().isAfter(dataLimite))
                .filter(pedido -> pedido.getStatus() == StatusPedido.PAGO)
                .map(Pedido::getValorTotal)
                .reduce(0f, Float::sum);
    }

    public void atualizarCategoria(){

        float totalCompra = totalValorCompra();

        if (totalCompra >= 10000) {
            this.categoria = Categorias.DIAMANTE;
        } else if (totalCompra >= 7000) {
            this.categoria = Categorias.OURO;
        } else if (totalCompra >= 3000) {
            this.categoria = Categorias.PRATA;
        } else if (totalCompra >= 1000) {
            this.categoria = Categorias.BRONZE;
        } else {
            this.categoria = Categorias.SEM_CATEGORIA;
        }

    }
}
