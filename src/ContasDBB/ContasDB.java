package ContasDBB;
import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import Contas.ContaSalario;
import java.util.ArrayList;
import java.util.List;
public class ContasDB {

    private List<ContaCorrente>contaCorrenteList = new ArrayList<>();
    private List<ContaPoupanca>contaPoupancaList = new ArrayList<>();
    private List<ContaSalario>contaSalarioList = new ArrayList<>();

    public List<ContaCorrente> getContasCorrenteList() {
        return contaCorrenteList;
    }

    public List<ContaPoupanca> getContaPoupancaList() {
        return contaPoupancaList;
    }

    public List<ContaSalario> getContaSalarioList() {
        return contaSalarioList;
    }

    public void adicionarContaC( Conta conta){
        contaCorrenteList.add((ContaCorrente) conta);
    }
    public void adicionarContaP (Conta conta){
        contaPoupancaList.add((ContaPoupanca) conta);
    }
    public void adicionarContaS (Conta conta){
        contaSalarioList.add((ContaSalario)conta );
    }



    public Conta procurarContaPeloNomeCliente(String nome) {
        for(Conta conta : contaCorrenteList ){
            if (conta.getNomeCliente().equalsIgnoreCase(nome)) {
                return conta;
            }
        }

        for(Conta conta : contaPoupancaList ){
            if (conta.getNomeCliente().equalsIgnoreCase(nome)) {
                return conta;
            }
        }

        for(Conta conta : contaSalarioList ){
            if (conta.getNomeCliente().equalsIgnoreCase(nome)) {
                return conta;
            }
        }
        return null;
    }
    public Conta imprimirContas() {
        for(Conta contaCorrente : contaCorrenteList ){
            for(Conta conta : contaCorrenteList) {
                System.out.println(conta);
            }
        }

        for(Conta contaPoupanca : contaPoupancaList ){
            for (Conta conta : contaPoupancaList) {
                System.out.println(conta);
            }
        }

        for(Conta contaSalario : contaSalarioList ){
            for (Conta conta : contaSalarioList){
                System.out.println(conta);
            }
        }
        return null;
    }

    public void transferir(Conta contaSacado, Conta contaDepositado, double valor) {
        contaSacado.transferir(contaDepositado, valor);
    }
    public void sacar ( Conta contaSacado, double valor){
        contaSacado.sacar((valor));
    }

}
