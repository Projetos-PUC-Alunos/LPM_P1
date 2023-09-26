package com.aluguel.cliente;

public class Cliente {
    private long cpf;
    private String nome;
    private String endereco;

    public Cliente(long cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }
}
