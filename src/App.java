import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    private static void showMenu(){
        System.out.println("1 - cadastrar cliente");
        System.out.println("2 - buscar cliente por cpf");
        System.out.println("3 - cadastrar conta"); 
        System.out.println("4 - listar todos os clientes");
        System.out.println("5 - listas todas as contas");
        System.out.println("6 - depositar em uma conta");
        System.out.println("7 - sacar de uma conta");
        System.out.println("0 - Sair");
        System.out.println("Digite uma opção:");
    }
    
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);

        String nome,cpf,agencia,numero,email;
        Cliente cliente;
        ContaCorrente conta;
        double valor;
        int opcao,anoNascimento;

        Banco banco = new Banco("Bando teste", "teste@banco.com");


        showMenu();
        opcao = scan.nextInt();
        scan.nextLine();
        
        while(opcao != 0){
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    nome = scan.nextLine();
                    System.out.println("Digite o cpf:");
                    cpf = scan.nextLine();
                    System.out.println("Digite o e-mail:");
                    email = scan.nextLine();
                    System.out.println("Digite o ano de nascimento:");
                    anoNascimento = scan.nextInt();

                    cliente = new Cliente(nome,email,cpf, anoNascimento);

                    if(banco.adicionaCliente(cliente)){
                        System.out.println("Cliente adicionado!");
                    }else{
                        System.out.println("Não foi possível adicionar o cliente!");
                    }

                    System.out.println("###########");
                    break;
                case 2:
                    System.out.println("Digite um CPF:");
                    cpf = scan.nextLine();
                    
                    cliente = banco.buscaCliente(cpf);
                    
                    if(cliente != null){
                        System.out.println("Cliente encontrado!");
                        System.out.println("\t"+cliente.toString());
                    }else{
                        System.out.println("Cliente não encontrado!");
                    }

                    System.out.println("###########");
                    break;

                case 3:
                    System.out.println("Digite o cpf do cliente:");
                    cpf = scan.nextLine();
                    
                    cliente = banco.buscaCliente(cpf);
                    
                    if(cliente != null){
                        System.out.println("Cliente encontrado!");
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();

                        conta = new ContaCorrente(numero, agencia, cliente);

                        if(banco.adicionaConta(conta)){
                            System.out.println("Conta criada com sucesso!!");
                        }else{
                            System.out.println("Não foi possível criar a conta!");
                        }
                    }else{
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("###########");
                    break;
                case 4:
                    System.out.println("Listando todos os clientes...");
                    
                    for(Cliente cli:banco.getClientes()){
                        System.out.println("\t"+cli.toString());
                    }
                    System.out.println("###########");
                    break;
                case 5:
                    System.out.println("Listando todas as contas...");

                    for(ContaCorrente con:banco.getContas()){
                        System.out.println("\t"+con.toString());
                    }
                    System.out.println("###########");
                    break;
                case 6:
                    System.out.println("Digite o agência da conta:");
                    agencia = scan.nextLine();
                    System.out.println("Digite o número da conta:");
                    numero = scan.nextLine();
                    System.out.println("Valor para depositar:");
                    valor = scan.nextDouble();

                    conta = banco.buscaConta(numero, agencia);

                    if(conta != null){
                        conta.depositar(valor);
                        System.out.println("Depósito realizado com sucesso!");
                    }else{
                        System.out.println("Conta não localizada!");
                    }
                    System.out.println("###########");

                    break;
                case 7:
                    System.out.println("Digite o agência da conta:");
                    agencia = scan.nextLine();
                    System.out.println("Digite o número da conta:");
                    numero = scan.nextLine();
                    System.out.println("Valor para sacar:");
                    valor = scan.nextDouble();

                    conta = banco.buscaConta(numero, agencia);

                    if(conta != null){
                        if(conta.sacar(valor)){
                            System.out.println("Saque realizado com sucesso!");
                        }else{
                            System.out.println("Não há saldo disponível!!");
                        }
                    }else{
                        System.out.println("Conta não localizada!");
                    }

                    break;


                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            showMenu();
            opcao = scan.nextInt();
            scan.nextLine();
        }



    }
}
