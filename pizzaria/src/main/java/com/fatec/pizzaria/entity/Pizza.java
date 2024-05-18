package com.fatec.pizzaria.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Pizza {
    private String sabor;
    private BigDecimal valor;

    public Pizza(String sabor, BigDecimal valor) {
        this.sabor = sabor;
        this.valor = valor;
    }
}
