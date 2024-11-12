package Desafios.Mjolnir;
import java.util.Scanner;

public class Mjolnir {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int C = leitor.nextInt();
        String nome;

        for (int i = 0; i < C; i++) {
            nome = leitor.next();
            leitor.nextInt(); // Lê o valor, mas não armazena
            if (nome.equals("Thor")) System.out.println("Y");
            else System.out.println("N");
        }
        leitor.close();
    }
}
