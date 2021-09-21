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

        String nome,cpf,agencia,numero,email,cnpj;
        ClientePF cliente;
        String dono;
        double saldo, limite, taxaRend;
        ClientePJ clientepj;
        int pf_pj, tipcont, numeroFuncionarios;
        ContaCorrente conta;
        ContaCorrenteEsp contaEsp;
        ContaPoupanca contaPoup;
        double valor;
        int opcao,anoNascimento;

        Banco banco = new Banco("Bando teste", "teste@banco.com");


        showMenu();
        opcao = scan.nextInt();
        scan.nextLine();
        
        while(opcao != 0){
            switch (opcao) {
                case 1:
                    System.out.println("Pessoa Fisica digite 1 Juridica 2:");
                    pf_pj = scan.nextInt();
                    if ( pf_pj == 1) {

                    nome = scan.nextLine();
                    System.out.println("Digite o nome:");
                    nome = scan.nextLine();
                    System.out.println("Digite o cpf:");
                    cpf = scan.nextLine();
                    System.out.println("Digite o e-mail:");
                    email = scan.nextLine();
                    System.out.println("Digite o ano de nascimento:");
                    anoNascimento = scan.nextInt();

                    cliente = new ClientePF(nome, email, cpf, anoNascimento);

                    if(banco.adicionaClientePF(cliente)){
                        System.out.println("Cliente adicionado!");
                    }else{
                        System.out.println("Não foi possível adicionar o cliente!");
                    }

                    System.out.println("###########");
                    break;

                    }
                    if ( pf_pj == 2) {

                        System.out.println("Digite o nome:");
                        nome = scan.nextLine();
                        System.out.println("Digite o cnpj:");
                        cnpj = scan.nextLine();
                        System.out.println("Digite o e-mail:");
                        email = scan.nextLine();
                        System.out.println("Digite o Numero de funcionarios:");
                        numeroFuncionarios = scan.nextInt();
    
                        clientepj = new ClientePJ(nome, email, cnpj, numeroFuncionarios);
    
                        if(banco.adicionaClientePJ(clientepj)){
                            System.out.println("Cliente adicionado!");
                        }else{
                            System.out.println("Não foi possível adicionar o cliente!");
                        }
    
                        System.out.println("###########");
                        break;
    
                        }
                    
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
                        System.out.println("Digite: 1 para Conta Corrente Simples 2 para Conta Corrente Especial e 3 para Conta Poupanca");
                        tipcont = scan.nextInt();

                    if(tipcont == 1 ){
                        scan.nextLine();
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
                    }

                    if(tipcont == 2 ){
                        numero = scan.nextLine();
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();
                        System.out.println("Digite o saldo:");
                        saldo = scan.nextDouble();
                        System.out.println("Digite o limite:");
                        limite= scan.nextDouble();
                        

                        contaEsp = new ContaCorrenteEsp( numero,  agencia, cliente, saldo ,limite);

                        if(banco.adicionaConta(contaEsp)){
                            System.out.println("Conta criada com sucesso!!");
                        }else{
                            System.out.println("Não foi possível criar a conta!");
                        }
                    }

                    if(tipcont == 3 ){
                        scan.nextLine();
                        System.out.println("Digite o número da conta:");
                        numero = scan.nextLine();
                        System.out.println("Digite a agência da conta:");
                        agencia = scan.nextLine();
                        System.out.println("Digite o saldo:");
                        saldo = scan.nextDouble();
                        System.out.println("Digite o limite:");
                        limite= scan.nextDouble();
                        System.out.println("Digite a taxa de rendimento:");
                        taxaRend= scan.nextDouble();
                        

                        contaPoup = new ContaPoupanca(numero,  agencia, cliente, saldo ,limite, taxaRend);

                        if(banco.adicionaConta(contaPoup)){
                            System.out.println("Conta criada com sucesso!!");
                        }else{
                            System.out.println("Não foi possível criar a conta!");
                        }
                    }
            
                        
                    }else{
                        System.out.println("Cliente não encontrado!");
                    }
                    System.out.println("###########");
                    break;
                case 4:
                    System.out.println("Listando todos os clientes...");
                    
                    for(ClientePF cli:banco.getClientes()){
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
                    System.out.println("###########");
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
