package ContasDBB;

import Contas.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupancaDB {
    private List<Conta> contaPoupancalist = new ArrayList<>();

    public void adicionarConta( Conta conta ) {
        contaPoupancalist.add(conta);

    }


}

