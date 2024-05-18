package com.fatec.pizzaria.repository;

import com.fatec.pizzaria.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
