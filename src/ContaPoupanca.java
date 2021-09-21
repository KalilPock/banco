public class ContaPoupanca extends ContaCorrente {
   
    private double limite = 400;
    private double taxaRend = 2;

    public ContaPoupanca(String numero, String agencia, ClientePF dono, double saldo ,double limite, double taxaRend) {
        super(numero,agencia,dono,saldo);
        this.limite = limite;
        this.taxaRend = taxaRend;        
    }
    
    boolean sacar(double valor){
        if(valor <= saldo+limite){
            saldo -= valor;
            return true;
        }
        return false;
    }

    void render(){
        saldo += saldo * taxaRend / 100;
     }
    

    public String toString(){
        return " Agência: "+agencia+" Número: "+numero+" Saldo R$:"+saldo+" Dono:["+dono+"]";
    }
    
    
}

