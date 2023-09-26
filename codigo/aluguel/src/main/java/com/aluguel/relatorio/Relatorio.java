package com.aluguel.relatorio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import com.aluguel.aluguel.Aluguel;


public class Relatorio {

    NumberFormat formatter = new DecimalFormat("#0.00");

    public void relatorioMensal(int mes, int ano, ArrayList<Aluguel> alugueis) {
        // imprimir relatorio geral de alugueis do mes 
        Double rendaMensalTotal = 0.0;
        for (Aluguel aluguel : alugueis){
            Date dataAluguel = aluguel.getDataInicio();
            int mesAluguel = dataAluguel.getMonth() + 1; // Os meses em Date são baseados em 0 (janeiro = 0)
            int anoAluguel = dataAluguel.getYear() + 1900; // Contagem de anos em Date começa a partir de 1900
            
            if (mes == mesAluguel && ano == anoAluguel) {
                System.out.println(aluguel.toString());
                rendaMensalTotal += aluguel.getPrecoTotal();
            }
        }
        System.out.println("RENDA TOTAL DO MÊS: \tR$ " + formatter.format(rendaMensalTotal));
    }

    public void relatorioGeralPorPessoa(String cliente, ArrayList<Aluguel> alugueis){
        System.out.println( "Cliente: \t" + cliente + "\n");
        for (Aluguel aluguel : alugueis){
            String clienteAluguel = aluguel.getCliente().getNome();
            if (cliente.equals(clienteAluguel)) {
                System.out.print("Equipamento:\t" + aluguel.getEquipamento().getTipo() + "\nPreço do aluguel: \t" + formatter.format(aluguel.getPrecoTotal()) + "\n\n");
            }
        }
    }
}
