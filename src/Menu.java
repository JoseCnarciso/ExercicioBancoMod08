import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import Contas.ContaSalario;
import ContasDBB.ContasDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static ContasDB contasDB = new ContasDB();
    static Scanner scanner = new Scanner(System.in);




    public static void main( String[] args ) throws ParseException {

//Cria se o primeiro laço de repetição do menu  Primeira camada.
        int opc ;
        do {
            System.out.println("======= Menu de Atendimento ========");
            System.out.println("-1- Cadastrar nova Conta: ");
            System.out.println("-2- Listar contas: ");
            System.out.println("-3- Transferência: ");
            System.out.println("-4- Sacar: ");


            System.out.println("-0- SAIR: ");
            opc = scanner.nextInt();
            // chama o metodo a ser utilizado que seria as opções a serem escolhidas no menu .... segunda camada
            processo(opc);

        } while (opc != 0);
    }
// cria se o metodo processo e anexa a variavel opc para que direcione a informação executada no menu principal
    public static void processo( int opc ) throws ParseException {
        // Segunda camada
        // cria se o switch case e dento dele criamos os cases com novos loops e menus de opções com um novo switch case
        switch (opc) {
            case 1: {
                // sempre criar uma variável nova para cada case .. assim não entra em conflito com os novos cases
                int opcCadastrarConta = -1;
                do {
                    System.out.println("Qual tipo de conta deseja cadastrar");
                    System.out.println("1 conta corrente");
                    System.out.println("2 conta poupança");
                    System.out.println("3 conta salario");
                    System.out.println("0 voltar ao menu principal");

                    opcCadastrarConta = scanner.nextInt();

                    switch (opcCadastrarConta) {
                        // Terceira camada
                        case 1: {
                            System.out.println("CADASTRO DE CONTA CORRENTE");
                            System.out.println("===========================");
                            System.out.println("Qual o nome do Cliente:");
                            String nome = scanner.next();

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
                            String nome = scanner.next();

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
                            String nome = scanner.next();

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
                    }
                    // sempre lembrar de colocar a variável no final e um break após o while , para que após finalizar o processo pedido não avance para o proximo case
                } while (opcCadastrarConta != 0);
            }break;
            case  2: {
                int opcListaContas = -1;
                do {
                    System.out.println("Lista de contas Cadastradas");
                    System.out.println("1 - Listar contas Corrente: ");
                    System.out.println("2 - Listas contas Poupança: ");
                    System.out.println("3 - Listas contas Salário: ");
                    System.out.println("0 - Voltar ao Menu principal: ");

                    opcListaContas = scanner.nextInt();

                    switch (opcListaContas) {
                        case 1: {
                            List<ContaCorrente> contaList = contasDB.getContasCorrenteList();
                            for (ContaCorrente conta : contaList) {
                                System.out.println("========================================");
                                System.out.println("Nome do cliente: " + conta.getNomeCliente());
                                System.out.println("Agencia: " + conta.getAgencia());
                                System.out.println("Número da conta: " + conta.getNumeroConta());
                                System.out.println("Limite cheque especial: " + conta.getChequeEspecial());
                                System.out.println("Saldo: " + conta.getSaldo());
                                System.out.println("Saldo disponivel: " + conta.getSaldoDisponivel());
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
                                System.out.println("Taxa de juros mensal: " + conta.getTaxaJuros());
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
                                System.out.println("Limite de saques mensal: " + conta.getLimiteDeSaques());
                                System.out.println("Saldo: " + conta.getSaldo());
                                System.out.println("========================================");
                            }break;
                        }
                    }
                } while (opcListaContas != 0);
            }break;
            case 3: {

                System.out.println("Transferência entre contas ");
                System.out.println("Digite o nome do cliente da conta a ser sacado :");
                String nomeClienteSacado = scanner.next();
                Conta contaSacado = contasDB.procurarContaPeloNomeCliente(nomeClienteSacado);

                System.out.println("-----------------------------------------------------------------");
                System.out.println("Nome: " + contaSacado.getNomeCliente());
                System.out.println("Agência: " + contaSacado.getAgencia());
                System.out.println("Número da conta: " + contaSacado.getNumeroConta());
                System.out.println("-----------------------------------------------------------------");

                System.out.println("Digite o nome do cliente da conta a ser depositado: ");
                String nomeClienteDepositado = scanner.next();

                Conta contaDepositado = contasDB.procurarContaPeloNomeCliente(nomeClienteDepositado);

                System.out.println("-----------------------------------------------------------------");
                System.out.println("Nome: " + contaDepositado.getNomeCliente());
                System.out.println("Agência: " + contaDepositado.getAgencia());
                System.out.println("Número da conta: " + contaDepositado.getNumeroConta());
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Digite o valor a ser transferido: ");
                double valor = scanner.nextDouble();
                contasDB.transferir(contaSacado, contaDepositado, valor);
                System.out.println("Nome: " + contaDepositado.getNomeCliente() +" " + "Agência: " + contaDepositado.getAgencia() + " " + "Conta: " + "Saldo atualizado: " +contaDepositado.getSaldo());
                System.out.println("Transferência feita com sucesso.");

            }break;
            case 4: {
                int opcSacar = -1;
                do {
                    System.out.println("-1- Sacar da conta corrente");
                    System.out.println("-2- Sacar da conta poupança");
                    System.out.println("-3- Sacar da conta salário");
                    System.out.println("-0- Sair");
                    opcSacar = scanner.nextInt();

                    switch (opcSacar) {
                        case 1: {
                              {
                                System.out.println("Sacar da conta corrente: ");
                                  System.out.println("Digite o nome do cliente da conta a ser sacado :");
                                  String nomeClienteSacado = scanner.next();
                                  Conta contaSacado = contasDB.procurarContaPeloNomeCliente(nomeClienteSacado);

                                  System.out.println("-----------------------------------------------------------------");
                                  System.out.println("Nome: " + contaSacado.getNomeCliente());
                                  System.out.println("Agência: " + contaSacado.getAgencia());
                                  System.out.println("Número da conta: " + contaSacado.getNumeroConta());
                                  System.out.println("Saldo: " + contaSacado.getSaldo());
                                  System.out.println("-----------------------------------------------------------------");
                                  System.out.println("Digite o valor a ser sacado: ");
                                  double valor = scanner.nextDouble();
                                  contasDB.sacar(contaSacado,valor);

                                  System.out.println("Saque realizado com sucesso");
                                  System.out.println("Saldo atual: " + contaSacado.getSaldo());
                            }break;
                        }
                        case 2: {
                            {
                                System.out.println("Sacar da conta poupança: ");
                                System.out.println("Digite o nome do cliente da conta a ser sacado :");
                                String nomeClienteSacado = scanner.next();
                                Conta contaSacado = contasDB.procurarContaPeloNomeCliente(nomeClienteSacado);

                                System.out.println("-----------------------------------------------------------------");
                                System.out.println("Nome: " + contaSacado.getNomeCliente());
                                System.out.println("Agência: " + contaSacado.getAgencia());
                                System.out.println("Número da conta: " + contaSacado.getNumeroConta());
                                System.out.println("Saldo: " + contaSacado.getSaldo());
                                System.out.println("-----------------------------------------------------------------");
                                System.out.println("Digite o valor a ser sacado: ");
                                double valor = scanner.nextDouble();
                                contasDB.sacar(contaSacado,valor);

                                System.out.println("Saque realizado com sucesso");
                                System.out.println("Saldo atual: " + contaSacado.getSaldo());
                            }break;
                        }
                        case 3: {
                            {
                                System.out.println("Sacar da conta salário: ");
                                System.out.println("Digite o nome do cliente da conta a ser sacado :");
                                String nomeClienteSacado = scanner.next();
                                Conta contaSacado = contasDB.procurarContaPeloNomeCliente(nomeClienteSacado);

                                System.out.println("-----------------------------------------------------------------");
                                System.out.println("Nome: " + contaSacado.getNomeCliente());
                                System.out.println("Agência: " + contaSacado.getAgencia());
                                System.out.println("Número da conta: " + contaSacado.getNumeroConta());
                                System.out.println("Saldo: " + contaSacado.getSaldo());
                                System.out.println("-----------------------------------------------------------------");
                                System.out.println("Digite o valor a ser sacado: ");
                                double valor = scanner.nextDouble();
                                contasDB.sacar(contaSacado,valor);

                                System.out.println("Saque realizado com sucesso");
                                System.out.println("Saldo atual: " + contaSacado.getSaldo());
                            }break;
                        }
                    }
                } while (opcSacar != 0);
            }break;

        }
    }
}