
public class Main {
    public static void main(String[] args){
        // Criando Clientes
        Cliente cliente1 = new Cliente("Gustavo", "040242456-05");

        Cliente cliente2 = new Cliente("Mayron", "093872397-80");
     
        // Criação da Conta Corrente
        Conta cc = new ContaCorrente(cliente1);

        // Criação da Conta Poupança
        Conta poupanca = new ContaPoupanca(cliente2);

        cc.depositar(100);
        cc.transferencia(50, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
