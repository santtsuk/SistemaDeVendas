package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "roles")
public class Roles {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "role")
        private String role;

        @ManyToOne()
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")
        private Usuario usuario;

        public Roles() {
        }

        public Roles(String role) {
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
    }
