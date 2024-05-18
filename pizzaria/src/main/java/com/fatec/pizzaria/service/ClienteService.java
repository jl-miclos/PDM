package com.fatec.pizzaria.service;

import com.fatec.pizzaria.entity.Cliente;

import java.util.List;

public interface ClienteService {
    void criarCliente(Cliente cliente);
    List<Cliente> listarClientes();
    void atualizarCliente(Cliente cliente);
    void removerCliente(Long id);
}
