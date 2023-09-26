package com.aluguel;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import com.aluguel.aluguel.Aluguel;
import com.aluguel.cliente.Cliente;
import com.aluguel.equipamento.Equipamento;

/**
 * A Classe apresentada testa o método calcular valor total da classe Aluguel.
 * Para isso, são instanciados os objetos cliente, equipamento e LocalDate.
 * 
 * new Cliente() --> instancia um cliente para teste
 * 
 * @param cpf          contém o cpf do cliente
 * @param nome         nome completo do cliente para o Aluguel
 * @param endereco     endereco do cliente para Aluguel
 * 
 *                     new Equipamento() --> instancia um equipamento
 * @param codigo       codigo do equipamento
 * @param tipo         tipo do equipamento
 * @param descricao    descricao do equipamento
 * @param diaria       valor da diaria do equipamento
 * @param eAlugado     verifica se esta alugado
 * @param emManutencao verifica se esta em manutencao
 * 
 *                     new Aluguel() --> instancia um aluguel
 * @param Cliente      cliente que alugou
 * @param Equipamento  equipamento alugado
 * @param Date         datas do aluguel
 * 
 *                     calcularValorTotal()--> retorna o valor do aluguel
 *                     intanciado
 * @param Date
 * @return valor total dos dias alugados
 */

public class AluguelTest {
    @Test
    public void testingCalcularValormethod() {

        LocalDate dataAtualLocalDate = LocalDate.of(2023, 9, 5); // Por exemplo, 5 de setembro de 2023
        LocalDate dataAnteriorLocalDate = LocalDate.of(2023, 9, 1); // Por exemplo, 5 de setembro de 2023
        java.sql.Date dataAnterior = Date.valueOf(dataAnteriorLocalDate);
        java.sql.Date dataAtual = Date.valueOf(dataAtualLocalDate);

        Cliente cliente = new Cliente(00000000000, "Maria", "Teste");
        Equipamento equipamento = new Equipamento("CC", "escavadeira", 100.00, false, false);

        Aluguel aluguel = new Aluguel(cliente, equipamento, dataAnterior, dataAtual);

        assertEquals(aluguel.calcularValorTotal(dataAnterior, dataAtual), 400.00, 0.5);

    }
}
