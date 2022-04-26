package ContasDBB;

import Contas.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaSalarioDB {

    private List<Conta>contaSalarioList = new ArrayList<>();

    public  void adicionarConta(Conta conta){
        contaSalarioList.add(conta);
    }

}
