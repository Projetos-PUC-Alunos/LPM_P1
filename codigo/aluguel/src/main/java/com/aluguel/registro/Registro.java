package com.aluguel.registro;

import java.util.ArrayList;

import com.aluguel.aluguel.Aluguel;
import com.aluguel.equipamento.Equipamento;

public class Registro {
    private ArrayList<Aluguel> alugueis;
    private ArrayList<Equipamento> equipamentos;

    public Registro() {
        alugueis = new ArrayList<>();
        equipamentos = new ArrayList<>();
    }

    public ArrayList<Aluguel> getAllRegistroAlugueis() {
        return alugueis;
    }

    public ArrayList<Equipamento> getAllEquipamentos() {
        return equipamentos;
    }

    public void addAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public void registrarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public void registrarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public Equipamento buscarEquipamento(int codigo) {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento.getCodigo() == codigo) {
                return equipamento;
            }
        }
        return null;
    }

}
