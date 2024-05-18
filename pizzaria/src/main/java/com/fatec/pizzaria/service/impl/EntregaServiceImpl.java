package com.fatec.pizzaria.service.impl;

import com.fatec.pizzaria.entity.Entrega;
import com.fatec.pizzaria.repository.EntregaRepository;
import com.fatec.pizzaria.service.EntregaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntregaServiceImpl implements EntregaService {

    private final EntregaRepository entregaRepository;

    @Override
    public void criarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Override
    public void atualizarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    @Override
    public void removerEntrega(Long id) {
        entregaRepository.deleteById(id);
    }

    public void confirmarRecebimento() {
        // TODO
    }

    public boolean verificarPagamento() {
        // TODO
        return true;
    }
}
