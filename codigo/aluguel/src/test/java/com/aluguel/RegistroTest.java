package com.aluguel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.aluguel.equipamento.Equipamento;
import com.aluguel.registro.Registro;

public class RegistroTest {

    private Registro registro;
    private Equipamento equipamento;

    @Before
    public void setUp() {
        registro = new Registro();
        equipamento = new Equipamento("CC", "escavadeira", 100.00, false, false);
    }

    @Test
    public void testRegistrarEquipamento() {

        registro.registrarEquipamento(equipamento);
        ArrayList<Equipamento> equipamentos = registro.getAllEquipamentos();

        assertTrue(equipamentos.contains(equipamento));
    }

    @Test
    public void testBuscarEquipamentoExistente() {

        registro.registrarEquipamento(equipamento);
        int codigo = equipamento.getCodigo();
        Equipamento encontrado = registro.buscarEquipamento(codigo);

        assertEquals(equipamento, encontrado);
    }
}
