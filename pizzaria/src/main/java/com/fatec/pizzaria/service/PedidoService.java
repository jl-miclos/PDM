package com.fatec.pizzaria.service;

import com.fatec.pizzaria.entity.Pedido;

import java.util.List;

public interface PedidoService {
    void criarPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    void atualizarPedido(Pedido pedido);
    void removerPedido(Long id);
}
