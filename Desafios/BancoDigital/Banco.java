import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contasBanco;
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Conta> getContasBanco() {
        return contasBanco;
    }
    public void setContasBanco(List<Conta> contasBanco) {
        this.contasBanco = contasBanco;
    }
    
    

    
}
