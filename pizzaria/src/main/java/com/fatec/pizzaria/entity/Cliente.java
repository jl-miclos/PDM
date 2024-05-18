package com.fatec.pizzaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String endereco;
    private String codigoDeEntrega;

    public Cliente(String codigoDeEntrega, String endereco, String telefone, String nome, Long id) {
        this.codigoDeEntrega = codigoDeEntrega;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
        this.id = id;
    }
}
