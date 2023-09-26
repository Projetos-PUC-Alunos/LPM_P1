package com.aluguel.aluguel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.aluguel.cliente.Cliente;
import com.aluguel.equipamento.Equipamento;

public class Aluguel {
    private Cliente cliente;
    private Equipamento equipamento;
    private Date dataInicio;
    private Date dataTermino;
    private Double precoTotal;

    NumberFormat formatter = new DecimalFormat("#0.00");

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public Double getPrecoTotal(){
        return precoTotal;
    }
    

    public Aluguel(Cliente cliente, Equipamento equipamento, Date dataInicio, Date dataTermino) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.precoTotal = calcularValorTotal(this.getDataInicio(), this.getDataTermino());
    }

    public double  calcularValorTotal(Date dataInicio, Date dataTermino) {
        long diffInMillis = dataTermino.getTime() - dataInicio.getTime();
        long dias = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return dias * equipamento.getDiaria();
    }

    @Override
    public String toString() {
        return "-- VALOR TOTAL DO ALUGUEL: " + formatter.format(calcularValorTotal(this.dataInicio, this.dataTermino)) + " --\nNome: \t" + cliente.getNome() + "\nEndereço: \t"
                + cliente.getEndereco() + "\ncpf: \t" + cliente.getCpf() + "\nEquipamento: \t" + equipamento.getTipo()
                + "\n";
    }
}
