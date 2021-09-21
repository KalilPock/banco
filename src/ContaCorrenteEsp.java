public class ContaCorrenteEsp extends ContaCorrente {
   
    private double limite = 400 ;

    public ContaCorrenteEsp(String numero, String agencia, ClientePF dono, double saldo ,double limite) {
        super(numero,agencia,dono,saldo);
        this.limite = limite;
    }
    
    
    boolean sacar(double valor){
        if(valor <= saldo+limite){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public String toString(){
        return " Agência: "+agencia+" Número: "+numero+" Saldo R$:"+saldo+" Dono:["+dono+"]";
    }
}
