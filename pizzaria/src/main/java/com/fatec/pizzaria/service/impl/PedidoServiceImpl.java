package com.fatec.pizzaria.service.impl;

import com.fatec.pizzaria.entity.Pedido;
import com.fatec.pizzaria.repository.PedidoRepository;
import com.fatec.pizzaria.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public void criarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public void atualizarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public BigDecimal calcularTotal() {
        // TODO
        return new BigDecimal(0);
    }

    public String verificarStatusEntrega() {
        // TODO
        return "";
    }
}
