package ContasDBB;
import Contas.Conta;
import Contas.Tributavel;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteDB  {
private List<Conta>contaCorrenteList = new ArrayList<>();

    public List<Conta> getContaCorrenteList() {
        return contaCorrenteList;
    }

    public void adicionarConta( Conta conta) {
        contaCorrenteList.add(conta);
    }


    @Override
    public String toString() {
        return "ContaCorrenteDB{" +
                "contaCorrenteList=" + contaCorrenteList +
                '}';
    }


}
