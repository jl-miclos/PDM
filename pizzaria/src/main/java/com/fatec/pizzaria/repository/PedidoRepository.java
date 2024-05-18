package com.fatec.pizzaria.repository;

import com.fatec.pizzaria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
