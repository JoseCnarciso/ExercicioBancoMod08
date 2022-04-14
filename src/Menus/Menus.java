package Menus;

import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import Contas.ContaSalario;
import ContasDBB.ContasDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menus {



    public static void criarContas( int opc ) throws ParseException {
        ContasDB contasDB = new ContasDB();
        Scanner scanner = new Scanner(System.in);


        do {

            System.out.println("Qual tipo de conta deseja cadastrar");
            System.out.println("1 conta corrente");
            System.out.println("2 conta poupança");
            System.out.println("3 conta salario");
            System.out.println("0 voltar ao menu principal");


             int opco = scanner.nextInt();

            switch (opco) {

                case 1: {

                    System.out.println("CADSATRO DE CONTA CORRENTE");
                    System.out.println("===========================");
                    System.out.println("Qual o nome do Cliente:");
                    String nome = scanner.nextLine();

                    System.out.println("Qual a agencia: ");
                    int agencia = scanner.nextInt();

                    System.out.println("Qual o numero da conta");
                    int numConta = scanner.nextInt();

                    System.out.println("Qual o saldo a ser depositado");
                    double saldo = scanner.nextDouble();

                    System.out.println("Limite cheque especial a ser liberado");
                    double chequeEspecial = scanner.nextDouble();

                    ContaCorrente novaContaCorrente = new ContaCorrente(nome, agencia, numConta, saldo, chequeEspecial);

                    contasDB.adicionarContaC(novaContaCorrente);
                    break;
                }

                case 2: {
                    System.out.println("CADASTRO CONTA POUPANÇA");
                    System.out.println("===========================");

                    System.out.println("Qual o nome do Cliente:");
                    String nome = scanner.nextLine();

                    System.out.println("Qual a agencia: ");
                    int agencia = scanner.nextInt();

                    System.out.println("Qual o numero da conta");
                    int numConta = scanner.nextInt();

                    System.out.println("Qual o saldo a ser depositado");
                    double saldo = scanner.nextDouble();

                    System.out.println("Taxa de juros mensal");
                    double taxaDejuros = scanner.nextDouble();

                    System.out.println("Data da abertura da conta");
                    String dataString = scanner.next();
                    Date dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                    ContaPoupanca novaContaPoupanca = new ContaPoupanca(nome, agencia, numConta, saldo, dataCadastro, taxaDejuros);
                    contasDB.adicionarContaP(novaContaPoupanca);
                    break;
                }

                case 3: {
                    System.out.println("CADASTRO DE CONTA SALÁRIO");
                    System.out.println("===========================");

                    System.out.println("Qual o nome do Cliente:");
                    String nome = scanner.nextLine();

                    System.out.println("Qual a agencia: ");
                    int agencia = scanner.nextInt();

                    System.out.println("Qual o numero da conta");
                    int numConta = scanner.nextInt();

                    System.out.println("Qual o saldo a ser depositado");
                    double saldo = scanner.nextDouble();

                    System.out.println("Limite de saques mensal");
                    double limiteDeSaques = scanner.nextDouble();

                    ContaSalario novaContaSalario = new ContaSalario(nome, agencia, numConta, saldo, (int) limiteDeSaques);
                    contasDB.adicionarContaS(novaContaSalario);
                    break;
                }
            }break;

        } while (opc != 0);

    }
    public static   void listarContas ( int opc) {
        ContasDB contasDB = new ContasDB();
        Scanner scanner = new Scanner(System.in);



        do{
            System.out.println("Lista de contas Cadastradas");
            System.out.println("1 - Listar contas Corrente: ");
            System.out.println("2 - Listar contas Poupança: ");
            System.out.println("3 - Listar contas Salário: ");
            System.out.println("0 - Voltar ao Menu principal: ");


            switch (opc) {
                case 1: {
                    List<ContaCorrente> contaList = contasDB.getContasList();
                    for (ContaCorrente conta : contaList) {
                        System.out.println("========================================");
                        System.out.println("Nome do cliente: " + conta.getNomeCliente());
                        System.out.println("Agencia: " + conta.getAgencia());
                        System.out.println("Número da conta: " + conta.getNumeroConta());
                        System.out.println("Limite cheque especial: " + conta.getChequeEspecial());
                        System.out.println("Saldo: " + conta.getSaldo());
                        System.out.println("========================================");

                    }break;
                }
                case 2: {
                    List<ContaPoupanca> poupancaList = contasDB.getContaPoupancaList();
                    for (ContaPoupanca conta : poupancaList) {
                        System.out.println("========================================");
                        System.out.println("Nome do cliente: " + conta.getNomeCliente());
                        System.out.println("Agencia: " + conta.getAgencia());
                        System.out.println("Número da conta: " + conta.getNumeroConta());
                        System.out.println("Taxa de juros mensal" + conta.getTaxaJuros());
                        System.out.println("Saldo: " + conta.getSaldo());
                        System.out.println("========================================");

                    }break;
                }
                case 3: {
                    List<ContaSalario> contaSalarioList = contasDB.getContaSalarioList();
                    for (ContaSalario conta : contaSalarioList) {
                        System.out.println("========================================");
                        System.out.println("Nome do cliente: " + conta.getNomeCliente());
                        System.out.println("Agencia: " + conta.getAgencia());
                        System.out.println("Número da conta: " + conta.getNumeroConta());
                        System.out.println("Limite de saques mensal" + conta.getLimiteDeSaques());
                        System.out.println("Saldo: " + conta.getSaldo());
                        System.out.println("========================================");
                    }break;
                }
            }
        }while (opc != 0);
   }
}


