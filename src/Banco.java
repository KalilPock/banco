import java.util.ArrayList;

public class Banco {
    
    private String nome;
    private String email;
    private ArrayList<Cliente> clientes;
    private ArrayList<ContaCorrente> contas;

    public Banco(String nome, String email) {
        this.nome = nome;
        this.setEmail(email);
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public boolean adicionaCliente(Cliente cliente){
        
        //não pode haver cpf duplicado
        if(buscaCliente(cliente.getCpf())==null){
            clientes.add(cliente);
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
    public Cliente buscaCliente(String cpf){
        
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

    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }

    public ArrayList<ContaCorrente> getContas(){
        return this.contas;
    }

}
