package com.fatec.pizzaria.service;

import com.fatec.pizzaria.entity.Item;

import java.util.List;

public interface ItemService {
    void criarItem(Item item);
    List<Item> listarItens();
    void atualizarItem(Item item);
    void removerItem(Long id);
}
