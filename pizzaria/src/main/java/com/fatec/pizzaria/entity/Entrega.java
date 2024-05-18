package com.fatec.pizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataDeEntrega;

    @Temporal(TemporalType.TIME)
    private Date horaDeEntrega;

    private String tipoDePagamento;
    private String codigoDeEntrega;

    public Entrega(Long id, Date dataDeEntrega, Date horaDeEntrega, String tipoDePagamento, String codigoDeEntrega) {
        this.id = id;
        this.dataDeEntrega = dataDeEntrega;
        this.horaDeEntrega = horaDeEntrega;
        this.tipoDePagamento = tipoDePagamento;
        this.codigoDeEntrega = codigoDeEntrega;
    }
}
