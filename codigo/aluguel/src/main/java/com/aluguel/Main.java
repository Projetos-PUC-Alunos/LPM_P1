package com.aluguel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.aluguel.aluguel.Aluguel;
import com.aluguel.cliente.Cliente;
import com.aluguel.equipamento.Equipamento;
import com.aluguel.registro.Registro;
import com.aluguel.relatorio.Relatorio;


public class Main {
    static Registro registro = new Registro();
    static Relatorio relatorio = new Relatorio();
    static Scanner input = new Scanner(System.in);

    static Equipamento nEquipamento = new Equipamento("Cacamba", "carrega entulho", 258.90, false, false);
    
    public static void main(String[] args) throws ParseException {
        // # PRE CRIAÇÃO DE EQUPAMENTOS
        registro.registrarEquipamento(nEquipamento);
        nEquipamento = new Equipamento("carrinho de mao", "carrega areia", 58.00, false, false);
        registro.registrarEquipamento(nEquipamento);
    
        nEquipamento = new Equipamento("macarico", "queima coisas", 200.90, false, false);
        registro.registrarEquipamento(nEquipamento);

        int op = -1;
        while (op != 0) {
            System.out.printf(
                    "\n********** Aluguel de equipamento **********\n1 - Registrar novo aluguel\n2 - Relatório geral do mês\n3 - Consultar registro atuais e passados do cliente\n4 - Cadastrar equipamento\n\t ESCOLHA UMA OPÇÃO: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("---- NOVO ALUGUEL ----");
                    System.out.print("Nome completo: ");
                    String nome = input.nextLine();
                    nome = input.nextLine();

                    System.out.print("CPF: ");
                    long cpf = input.nextLong();
                    System.out.print("Endereco completo: ");
                    String endereco = input.nextLine();
                    endereco = input.nextLine();

                    int codeEq = selecionarEquipamento();
                    if (selecionarEquipamento() == 0) {
                        System.out.print(
                                "\n**** CADASTRE O PRODUTO NA OPÇÃO QUATRO (4) ****\n");
                        continue;
                    }
                    Equipamento equipamento = registro.buscarEquipamento(codeEq);
                    System.out.print(equipamento.toString());

                    System.out.print("Inicio da locacao (dd/mm/yyyy): ");
                    String inicio = input.nextLine();
                    inicio = input.nextLine();
                    Date dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(inicio);
                    System.out.print("Termino da locacao (dd/mm/yyyy): ");
                    String termino = input.nextLine();
                    Date dataTermino = new SimpleDateFormat("dd/MM/yyyy").parse(termino);

                    Cliente cliente = new Cliente(cpf, nome, endereco);

                    Aluguel aluguel = new Aluguel(
                            cliente,
                            equipamento,
                            dataInicio,
                            dataTermino);

                    registro.registrarAluguel(aluguel);
                    equipamento.setEAlugado(true);
                    
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print(aluguel.toString());
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("\n################## RELATORIO MENSAL ##################");
                    System.out.print("Insira o mês: ");
                    int mes = input.nextInt();
                    System.out.print("Insina o ano: ");
                    int ano = input.nextInt();
                    relatorio.relatorioMensal(mes, ano, registro.getAllRegistroAlugueis());
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("\n################## RELATORIO GERAL DO CLIENTE ##################");
                    System.out.print("Digite o nome do cliente: ");
                    String clienteNome = input.nextLine();
                    clienteNome = input.nextLine();
                    relatorio.relatorioGeralPorPessoa(clienteNome,  registro.getAllRegistroAlugueis());
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("\n**** CADASTRO DE EQUIPAMENTO ****\n");
                    System.out.print("Tipo do equipamento: ");
                    String Equipamento_tipo = input.nextLine();
                    Equipamento_tipo = input.nextLine();

                    System.out.print("Descrição: ");
                    String Equipamento_desc = input.nextLine();

                    System.out.print("Valor da diária em reais (R$ 0,00): ");
                    Double Equipamento_diaria = input.nextDouble();

                    input.nextLine().toLowerCase();
                    boolean EqeAlugado = obterResposta(
                            "O equipamento está alugado? (sim/nao): ",
                            input);

                    boolean EqeEmManutencao = obterResposta(
                            "O equipamento está em manutenção? (sim/nao): ",
                            input);

                    System.out.print("\n**** EQUIPAMENTO: ****\n");
                    Equipamento novoEquipamento = new Equipamento(
                            Equipamento_tipo,
                            Equipamento_desc,
                            Equipamento_diaria,
                            EqeAlugado,
                            EqeEmManutencao);

                    registro.registrarEquipamento(novoEquipamento);
                    System.out.print(novoEquipamento.toString());

                    break;
                default:
                    break;
            }
        }
    }

    public static int selecionarEquipamento() {
        int option = -1;
        ArrayList<Equipamento> equipamentos = registro.getAllEquipamentos();
        for (Equipamento equipamento : equipamentos) {
            if(!equipamento.getEAlugado()){
                System.out.println(equipamento.toString());
            }
        }
        System.out.print(
                "\nDigite o codigo equipamento acima ou digite zero (0), caso não tenha: ");
        option = input.nextInt();
        if (registro.buscarEquipamento(option) != null || option == 0)
            return option;
        return selecionarEquipamento();
    }

    public static boolean obterResposta(String prompt, Scanner input) {
        while (true) {
            System.out.print(prompt);
            String resposta = input.nextLine().toLowerCase();

            if (resposta.equals("sim")) {
                return true;
            } else if (resposta.equals("nao")) {
                return false;
            } else {
                System.out.println("Resposta inválida. Use 'sim' ou 'nao'.");
            }
        }
    }
}
