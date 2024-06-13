package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VendaTest {
    private Venda venda;

    @BeforeEach
    public void setUp() {
        venda = new Venda();
    }

    @Test
    public void testAdicionarItem() {
        Item item = new Item("Produto A", 10.0, 2);
        venda.adicionarItem(item);
        List<Item> itens = venda.getItens();
        assertEquals(1, itens.size());
        assertEquals("Produto A", itens.get(0).getNome());
    }

    @Test
    public void testGetTotalVenda() {
        venda.adicionarItem(new Item("Produto A", 10.0, 2));
        venda.adicionarItem(new Item("Produto B", 20.0, 1));
        assertEquals(40.0, venda.getTotalVenda(), 0.001);
    }

    @Test
    public void testGetItens() {
        Item itemA = new Item("Produto A", 10.0, 2);
        Item itemB = new Item("Produto B", 20.0, 1);
        venda.adicionarItem(itemA);
        venda.adicionarItem(itemB);
        List<Item> itens = venda.getItens();
        assertNotNull(itens);
        assertEquals(2, itens.size());
    }

    @Test
    public void testItemTotal() {
        Item item = new Item("Produto A", 10.0, 3);
        assertEquals(30.0, item.getTotal(), 0.001);
    }

    @Test
    public void testVendaSemItens() {
        assertEquals(0.0, venda.getTotalVenda(), 0.001);
    }

    @Test
    public void testAdicionarItemQuantidadeZero() {
        Item item = new Item("Produto A", 10.0, 0);
        venda.adicionarItem(item);
        assertEquals(0.0, venda.getTotalVenda(), 0.001);
    }
}

