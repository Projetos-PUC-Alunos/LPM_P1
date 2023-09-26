package com.aluguel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.aluguel.cliente.Cliente;

/***
 * A Classe apresentada testa a classe Cliente, verificando cada um dos seus métodos,
 * como criação de um Cliente e os getters.
 * 
 * setUp() --> cria um novo cliente para testar os getters do cliente instanciado.
 * @param cpf contém o cpf do cliente
 * @param nome nome completo do cliente para o Aluguel
 * @param endereco endereco do cliente para Aluguel
 * 
 * testGetNome() --> recupera o nome do cliente instanciado
 * @param nome
 * @return nome do cliente instanciado
 * 
 * testeGetCpf() --> recupera o cpf do cliente instanciado
 * @param cpf
 * @return cpf do cliente instanciado
 * 
 * testeGetEndereco()--> recupera o endereço do cliente instanciado/cadastrado
 * @param endereco
 * @return endereco do cliente instanciado
 * 
 */

public class ClienteTest {
    private Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente(12345678901L, "Belle", "PUCminas, 123");
    }

    @Test
    public void testGetNome() {
        assertEquals("Belle", cliente.getNome());
    }

    @Test
    public void testGetCpf() {
        assertEquals(12345678901L, cliente.getCpf());
    }

    @Test
    public void testGetEndereco() {
        assertEquals("PUCminas, 123", cliente.getEndereco());
    }
}
