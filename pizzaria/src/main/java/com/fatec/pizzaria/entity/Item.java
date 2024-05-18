package com.fatec.pizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;

    public Item(Long id, String descricao, BigDecimal precoUnitario, int quantidade, Pedido pedido) {
        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }
}
