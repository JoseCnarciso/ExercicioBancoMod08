import java.util.Scanner;

public class TesteMenu {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int opcGeral = -1;
        do {
            System.out.println("1 - Conta");
            System.out.println("2 - Relatorios");
            System.out.println("0 - Sair");

            opcGeral = scanner.nextInt();

            switch (opcGeral) {
                case 1 : {
                    int opcMenuConta = -1;
                    do {
                        System.out.println("1.1 - Cadastrar conta corrente");
                        System.out.println("1.2 - Cadastrar conta poupança");
                        System.out.println("1.0 - Sair");
                        opcMenuConta = scanner.nextInt();

                        switch (opcMenuConta) {
                            case 1 : {
                                int opcMenuContacORRENTE = -1;
                                do {
                                    System.out.println("2.1 - Cadastrar conta corrente");
                                    System.out.println("2.2 - Cadastrar conta poupança");
                                    System.out.println("2.0 - Sair");
                                    opcMenuContacORRENTE = scanner.nextInt();

                                } while (opcMenuContacORRENTE != 0);
                            }; break;
                        }
                    } while (opcMenuConta != 0);
                }; break;
            }
        } while (opcGeral != 0);
    }
}
