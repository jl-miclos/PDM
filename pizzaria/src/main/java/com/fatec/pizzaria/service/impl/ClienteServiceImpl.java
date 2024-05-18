package com.fatec.pizzaria.service.impl;

import com.fatec.pizzaria.entity.Cliente;
import com.fatec.pizzaria.repository.ClienteRepository;
import com.fatec.pizzaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public void criarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
