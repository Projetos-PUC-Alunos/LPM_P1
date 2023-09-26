package com.aluguel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.aluguel.equipamento.Equipamento;

public class EquipamentoTest {

    private Equipamento equipamento;

    @Before
    public void setUp() {
        equipamento = new Equipamento("CC", "escavadeira", 100.00, false, false);

    }

    @Test
    public void testGerarCodigo() {

        int codigo = equipamento.gerarCodigo("CC");
        assertTrue(codigo >= 10000);
        assertTrue(codigo <= 99999);
    }

    @Test
    public void testGetAlugado() {
        assertTrue(!equipamento.getEAlugado());
    }

    @Test
    public void testGetEmManutencao() {
        assertTrue(!equipamento.getEmManutencao());
    }

    @Test
    public void testGetAlugadoString() {
        assertEquals("Não", equipamento.getEAlugadoString());
    }

    @Test
    public void testGetEmManutencaoString() {
        assertEquals("Não", equipamento.getEmManutencaoString());
    }
}
