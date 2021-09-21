public class ClientePJ extends Cliente{
    
    private String cnpj;
    private int numeroFuncionarios;

    public ClientePJ(String nome, String email, String cnpj, int numeroFuncionarios) {
        super(nome, email);
        
        this.cnpj = cnpj;
        this.setNumeroFuncionarios(numeroFuncionarios);
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getCpnj() {
        return cnpj;
    }

    public String toString(){
        return "Nome: "+getNome()+" E-mail:"+getEmail()+" CNPJ:"+cnpj+" Funcionários:"+numeroFuncionarios;
    }
    
}
