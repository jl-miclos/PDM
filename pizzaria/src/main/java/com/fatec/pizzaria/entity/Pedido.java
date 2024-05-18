package com.fatec.pizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataDeEntrega;

    @Temporal(TemporalType.TIME)
    private Date horaDeEntrega;

    private int quantidadeItens;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "entregaId")
    private Entrega entrega;

    public Pedido(Long id, Date dataDeEntrega, Date horaDeEntrega, int quantidadeItens, BigDecimal valorTotal, Cliente cliente, Entrega entrega) {
        this.id = id;
        this.dataDeEntrega = dataDeEntrega;
        this.horaDeEntrega = horaDeEntrega;
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.entrega = entrega;
    }
}
