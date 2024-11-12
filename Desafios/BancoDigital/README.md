## Domínio/Problema

#### Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução
#### Orientada a Objetos em java. Para isso, vamos interpretar o seguinte cenário:

- Um banco oferece aos seus clientes dois tipos de contas (Corrente e Poupança), as 
quais possuem funcionalidades de depósito, saque e transferência (Entre contas da própria Instituição)

## Desafio Do projeto

#### Agora é a sua hora de brilhar, use todo o seu conhecimento em JAVA e OO para evoluir
#### O projeto criado nesta aula. Para isso, seguem algumas sugestões:

- Use todo o seu conhecimento para estender o domínio, incluindo novas classes, atributos
e/ou métodos.

- Incluir o Lombok ao projeto para reduzir verbosidade de código.

#### Para incluir o lombok o projeto precisamos em Maven ou Gradle que não é o caso.
#### Porém segue abaixo o passo a passo:

## 1° PASSO 
- MAVEN (Adicione o Lombok no seu arquivo `pom.xml`)
```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.28</version> <!-- Verifique a última versão disponível -->
        <scope>provided</scope>
    </dependency>
```

- Gradle (Adicione o Lombok no seu arquivo `build.gradle`)
```groovy
    dependencies {
        compileOnly 'org.projectlombok:lombok:1.18.28'
        annotationProcessor 'org.projectlombok:lombok:1.18.28'
    }
```
## 2° PASSO
- Atualização das Classes com Lombok

### Banco 
```java
    import lombok.Getter;
    import lombok.Setter;

    import java.util.List;

    @Getter
    @Setter
    public class Banco {
        private String nome;
        private List<Conta> contasBanco;
    }

```

### Cliente
```java
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    public class Cliente {
        private String nome;
        private String CPF;
    }
```

### Cliente
```java
    import lombok.Getter;

    @Getter
    public abstract class Conta implements IConta {
        protected int nrConta;
        protected int agencia;
        protected double saldo;
        protected Cliente cliente;
        private static final int AGENCIA_PADRAO = 630;
        private static int SEQUENCIAL = 1;

        public Conta(Cliente cliente) {
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
            System.out.println(String.format("Saldo: %.2f", this.saldo));
        }
    }
```