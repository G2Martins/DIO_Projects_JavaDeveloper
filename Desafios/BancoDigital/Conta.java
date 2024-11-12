
public abstract class Conta implements IConta {
    protected int nrConta;
    protected int agencia;
    protected double saldo;
    protected Cliente cliente;
    private static final int AGENCIA_PADRAO = 630;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.nrConta = SEQUENCIAL++;
        this.cliente = cliente;
    }
    
    @Override
    public void sacar(double valor) {
        saldo -= valor; 
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;   
    }

    @Override
    public void transferencia(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void ImprimirInfoComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Número da Conta: %d", this.nrConta));
        System.out.println(String.format("Agencia: %.2f", this.saldo));
    }
    
    public int getNrConta() {
        return nrConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }
    
}
