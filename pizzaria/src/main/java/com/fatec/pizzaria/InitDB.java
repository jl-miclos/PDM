package com.fatec.pizzaria;

import com.fatec.pizzaria.entity.*;
import com.fatec.pizzaria.service.ClienteService;
import com.fatec.pizzaria.service.EntregaService;
import com.fatec.pizzaria.service.ItemService;
import com.fatec.pizzaria.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Configuration
@Profile("dev")
public class InitDB implements CommandLineRunner {

    private final ClienteService clienteService;
    private final EntregaService entregaService;
    private final ItemService itemService;
    private final PedidoService pedidoService;

    public InitDB(ClienteService clienteService, EntregaService entregaService, ItemService itemService, PedidoService pedidoService) {
        this.clienteService = clienteService;
        this.entregaService = entregaService;
        this.itemService = itemService;
        this.pedidoService = pedidoService;
    }

    @Override
    public void run(String... args) {
        final int QUANTIDADE_PEDIDOS_CLIENTE = 3;
        final int QUANTIDADE_ITENS_PEDIDO = 3;

        List<Cliente> clientes = new ArrayList<Cliente>();
        List<Pedido> pedidos = new ArrayList<Pedido>();
        List<Item> itens = new ArrayList<Item>();

        final Pizza[] sabores = {
                new Pizza("Bacon", new BigDecimal(33)),
                new Pizza("Mussarela", new BigDecimal(30)),
                new Pizza("Calabresa", new BigDecimal(33)),
                new Pizza("4 Queijos", new BigDecimal(40)),
                new Pizza("Frango", new BigDecimal(40)),
                new Pizza("Portuguesa", new BigDecimal(45)),
                new Pizza("Marguerita", new BigDecimal(45)),
                new Pizza("Brigadeiro", new BigDecimal(50)),
                new Pizza("Chocolate", new BigDecimal(50))
        };

        Cliente cliente1 = new Cliente("10", "Rua Leste", "912341234", "Alberto", (long) 1);
        clientes.add(cliente1);
        clienteService.criarCliente(cliente1);
        Cliente cliente2 = new Cliente("45", "Rua Norte", "987654321", "Bernardo", (long) 2);
        clientes.add(cliente2);
        clienteService.criarCliente(cliente2);
        Cliente cliente3 = new Cliente("172", "Avenida Central", "910100101", "Cristina", (long) 3);
        clientes.add(cliente3);
        clienteService.criarCliente(cliente3);

        Entrega entrega = new Entrega((long) 1, new Date(), new Date(), "cartão", "1");
        entregaService.criarEntrega(entrega);

        for (int i = 0; i < clientes.size(); i++) {
            for (int j = 1; j <= QUANTIDADE_PEDIDOS_CLIENTE; j++) {
                long id = i * QUANTIDADE_PEDIDOS_CLIENTE + j;
                Pedido pedido = new Pedido(id, new Date(), new Date(), randInt(1, 3), new BigDecimal((i * 3) + j + 1), clientes.get(i), entrega);
                pedidos.add(pedido);
            }
        }

        for (int i = 0; i < pedidos.size(); i++) {
            BigDecimal valorTotal = new BigDecimal(0);
            int quantidadeItens = 0;
            for (int j = 1; j <= QUANTIDADE_ITENS_PEDIDO; j++) {
                long id = i * QUANTIDADE_ITENS_PEDIDO + j;
                Pizza pizza = sabores[randInt(0, sabores.length - 1)];
                int quantidade = randInt(1, 2);
                Item item = new Item(id, "Pizza de " + pizza.getSabor(), pizza.getValor(), quantidade, pedidos.get(i));
                itens.add(item);
                valorTotal = valorTotal.add(pizza.getValor().multiply(new BigDecimal(quantidade)));
                quantidadeItens += 1;
            }
            pedidos.get(i).setValorTotal(valorTotal);
            pedidos.get(i).setQuantidadeItens(quantidadeItens);
        }

        for (Pedido pedido : pedidos) {
            pedidoService.criarPedido(pedido);
        }

        for (Item item : itens) {
            itemService.criarItem(item);
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
