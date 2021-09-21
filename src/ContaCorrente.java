public class ContaCorrente {
    
    //atributos => caracteristicas
    protected String numero;
    protected String agencia;
    protected double saldo;
    //Cliente
    protected ClientePF dono;

    
    //métodos => ações
    public ContaCorrente(String numero, String agencia, ClientePF dono, double saldo){
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dono = dono;
    }

    public ContaCorrente(String numero, String agencia, ClientePF dono){
        this(numero,agencia,dono,0.0);
    }
    
    boolean sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    boolean depositar(double valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }

    public String getNumero(){
        return numero;
    }

    public String getAgencia(){
        return agencia;
    }

    public double getSaldo(){
        return saldo;
    }

    public ClientePF getDono(){
        return this.dono;
    }

    public String toString(){
        return " Agência: "+agencia+" Número: "+numero+" Saldo R$:"+saldo+" Dono:["+dono+"]";
    }

}
