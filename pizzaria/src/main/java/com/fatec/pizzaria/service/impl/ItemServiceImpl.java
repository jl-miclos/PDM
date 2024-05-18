package com.fatec.pizzaria.service.impl;

import com.fatec.pizzaria.entity.Item;
import com.fatec.pizzaria.repository.ItemRepository;
import com.fatec.pizzaria.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public void criarItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

    @Override
    public void atualizarItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void removerItem(Long id) {
        itemRepository.deleteById(id);
    }
}
