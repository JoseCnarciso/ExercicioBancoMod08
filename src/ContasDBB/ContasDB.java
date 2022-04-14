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

    public List<ContaCorrente> getContasList() {
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


    public void imprimiContas() {
        for(Conta conta : contaCorrenteList ){
            System.out.println(conta);
        }
    }

}
