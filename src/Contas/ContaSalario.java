package Contas;

public class ContaSalario extends Conta{
    private int limiteDeSaques;

    public ContaSalario( String nomeCliente, int agencia, int numeroConta, double saldo, int limiteDeSaques ) {
        super(nomeCliente, agencia, numeroConta, saldo);
        this.limiteDeSaques = limiteDeSaques;
    }

    @Override
    public void transferir( Conta contaDestino, double valor ) {
        double sacado = sacar(valor);
        contaDestino.depositar(sacado);

    }

    @Override
    public double sacar( double valor ) {
        if (limiteDeSaques > 0) {
            setSaldo(getSaldo() - valor);
            limiteDeSaques --;
        } else{
            System.out.println("Você atingiu o limites de saques mensal.");
        }
        return valor;
    }

    @Override
    public double depositar( double valor ) {
        setSaldo(getSaldo() + valor);
        return valor;
    }

    @Override
    public String toString() {
        return "ContaSalario{" +
                "saldo=" + saldo +
                ", limiteDeSaques=" + limiteDeSaques +
                '}';
    }


    public int getLimiteDeSaques() {
        return limiteDeSaques;
    }
}
