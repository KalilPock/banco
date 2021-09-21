import java.util.ArrayList;

public class Banco{
    
    private String nome;
    private String email;
    private ArrayList<ContaPoupanca> contasPoupancas;
    private ArrayList<ContaCorrenteEsp> contasEsps;
    private ArrayList<ContaCorrente> contas;
    private ArrayList<ClientePJ> clientePJs;
    private ArrayList<ClientePF> clientes;

    public Banco(String nome, String email) {
        this.nome = nome;
        this.setEmail(email);
        clientes = new ArrayList<>();
        clientePJs = new ArrayList<>();
        contas = new ArrayList<>();
        contasEsps = new ArrayList<>();
        contasPoupancas = new ArrayList<>();
    }

    public boolean adicionaClientePF(ClientePF cliente){
        
        //não pode haver cpf duplicado
        if(buscaCliente(cliente.getCpf())==null){
            clientes.add(cliente);
            return true;
        }

        return false;
        
    }
    public boolean adicionaClientePJ(ClientePJ clientepj){
        
        //não pode haver cpf duplicado
        if(buscaCliente(clientepj.getCpnj())==null){
            clientePJs.add(clientepj);
            return true;
        }

        return false;
        
    }

    public boolean adicionaConta(ContaCorrenteEsp contaEsp){
        
        //não pode haver numero e agencia duplicados
        if(buscaConta(contaEsp.getNumero(), contaEsp.getAgencia())==null){
            contasEsps.add(contaEsp);
            return true;
        }
        return false;
    }

    public boolean adicionaConta(ContaPoupanca contaPoup){
        
        //não pode haver numero e agencia duplicados
        if(buscaConta(contaPoup.getNumero(), contaPoup.getAgencia())==null){
            contasPoupancas.add(contaPoup);
            return true;
        }
        return false;
    }

    public boolean adicionaConta(ContaCorrente conta){
        
        //não pode haver numero e agencia duplicados
        if(buscaConta(conta.getNumero(), conta.getAgencia())==null){
            contas.add(conta);
            return true;
        }
        return false;
    }

    //procurar na coleção de clientes um cliente com o CPF
    public ClientePF buscaCliente(String cpf){
        
        //percorer todos os clientes        
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getCpf().equals(cpf)){
                return clientes.get(i);
            }
        }

        return null;
    }
    
    public ContaCorrente buscaConta(String numero, String agencia){
        
        for(ContaCorrente c:contas){
            if(c.getAgencia().equals(agencia) && c.getNumero().equals(numero)){
                return c;
            }
        }

        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<ClientePF> getClientes(){
        return this.clientes;
    }

    public ArrayList<ContaCorrente> getContas(){
        return this.contas;
    }
    

}
