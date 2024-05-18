package com.fatec.pizzaria.service;

import com.fatec.pizzaria.entity.Entrega;

import java.util.List;

public interface EntregaService {
    void criarEntrega(Entrega entrega);
    List<Entrega> listarEntregas();
    void atualizarEntrega(Entrega entrega);
    void removerEntrega(Long id);
}
