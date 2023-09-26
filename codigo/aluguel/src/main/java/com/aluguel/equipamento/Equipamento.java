package com.aluguel.equipamento;

import java.util.Random;

public class Equipamento {
    private int codigo;
    private String tipo;
    private String descricao;
    private double diaria;
    private boolean eAlugado;
    private boolean emManutencao;

    public Equipamento(String tipo, String descricao, double diaria, boolean eAlugado,
            boolean emManutencao) {
        this.codigo = gerarCodigo(tipo);
        this.tipo = tipo;
        this.descricao = descricao;
        this.diaria = diaria;
        this.eAlugado = eAlugado || false;
        this.emManutencao = emManutencao || false;
    }

    public int gerarCodigo(String tipo) {
        Random random = new Random();
        int tresUltimosDigitos = random.nextInt(100000);
        return tresUltimosDigitos;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getEAlugado() {
        return eAlugado;
    }

    public void setEAlugado(boolean eAlugado) {
        this.eAlugado = eAlugado;
    }

    public String getEAlugadoString() {
        return emManutencao ? "Sim" : "Não";
    }

    public boolean getEmManutencao() {
        return emManutencao;
    }

    public String getEmManutencaoString() {
        return emManutencao ? "Sim" : "Não";
    }

    public double getDiaria() {
        return diaria;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Código: \t" + this.codigo + "\nEquipamento: \t" + this.tipo + "\nDescricao: t" + this.descricao
                + "\nDiaria: \t" + this.diaria + "\n";
    }
}
