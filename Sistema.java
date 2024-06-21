import java.util.Scanner;


class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

   
    public void cadastrar() {
        
        System.out.println("Pessoa cadastrada: " + nome);
    }

    public void consultar() {
       
        System.out.println("Consultando pessoa: " + nome);
    }

    public void atualizar() {
        
        System.out.println("Atualizando pessoa: " + nome);
    }

    public void excluir() {
        
        System.out.println("Excluindo pessoa: " + nome);
    }
}


abstract class Funcionario extends Pessoa {
    private int codigo;
    private double salario;

    public Funcionario(String nome, int idade, int codigo, double salario) {
        super(nome, idade);
        this.codigo = codigo;
        this.salario = salario;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    
    public abstract double calcularSalario();
}


class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, int idade, int codigo, double salario, String departamento) {
        super(nome, idade, codigo, salario);
        this.departamento = departamento;
    }

    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public double calcularSalario() {
   
        return getSalario() * 1.2; 
    }
}

class FuncionarioComum extends Funcionario {
    public FuncionarioComum(String nome, int idade, int codigo, double salario) {
        super(nome, idade, codigo, salario);
    }

    @Override
    public double calcularSalario() {
       
        return getSalario(); 
    }
}

class Diretor extends Funcionario {
    private String area;

    public Diretor(String nome, int idade, int codigo, double salario, String area) {
        super(nome, idade, codigo, salario);
        this.area = area;
    }

    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public double calcularSalario() {
       
        return getSalario() * 1.5; 
    }
}

class Secretario extends Funcionario {
    public Secretario(String nome, int idade, int codigo, double salario) {
        super(nome, idade, codigo, salario);
    }

    @Override
    public double calcularSalario() {
       
        return getSalario(); 
    }
}


public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Gerente gerente = new Gerente("João", 35, 1, 5000.0, "Financeiro");
        FuncionarioComum funcionario = new FuncionarioComum("Maria", 30, 2, 3000.0);
        Diretor diretor = new Diretor("Carlos", 45, 3, 10000.0, "Operações");
        Secretario secretario = new Secretario("Ana", 25, 4, 2500.0);

        
        int opcao;
        do {
            System.out.println("\n=== Sistema de Gerenciamento de Funcionários ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastro de Funcionário:");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.print("Tipo (G - Gerente, C - Funcionário Comum, D - Diretor, S - Secretário): ");
                    char tipo = scanner.nextLine().toUpperCase().charAt(0);

                    Funcionario novoFuncionario = null;
                    switch (tipo) {
                        case 'G':
                            System.out.print("Departamento: ");
                            String departamento = scanner.nextLine();
                            novoFuncionario = new Gerente(nome, idade, codigo, salario, departamento);
                            break;
                        case 'C':
                            novoFuncionario = new FuncionarioComum(nome, idade, codigo, salario);
                            break;
                        case 'D':
                            System.out.print("Área: ");
                            String area = scanner.nextLine();
                            novoFuncionario = new Diretor(nome, idade, codigo, salario, area);
                            break;
                        case 'S':
                            novoFuncionario = new Secretario(nome, idade, codigo, salario);
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                            continue;
                    }

                    if (novoFuncionario != null) {
                        novoFuncionario.cadastrar();
                    }
                    break;

                case 2:
                    System.out.println("\nConsulta de Funcionário:");
                    System.out.print("Código do funcionário: ");
                    int codigoConsulta = scanner.nextInt();

                    
                    System.out.println("Consultando funcionário de código " + codigoConsulta);
                    break;

                case 3:
                    System.out.println("\nAtualização de Funcionário:");
                    System.out.print("Código do funcionário: ");
                    int codigoAtualizacao = scanner.nextInt();

                   
                    System.out.println("Atualizando funcionário de código " + codigoAtualizacao);
                    break;

                case 4:
                    System.out.println("\nExclusão de Funcionário:");
                    System.out.print("Código do funcionário: ");
                    int codigoExclusao = scanner.nextInt();

                  
                    System.out.println("Excluindo funcionário de código " + codigoExclusao);
                    break;

                case 0:
                    System.out.println("Saindo do sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
