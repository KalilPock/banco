public class ClientePF extends Cliente{
    
    private String cpf;
    private int anoNascimento;
    
    public ClientePF(String nome, String email, String cpf,   int anoNascimento) {
        super(nome,email);

        this.cpf = cpf;
        this.anoNascimento = anoNascimento;
    }

    public String getCpf(){
        return this.cpf;
    }
    
    public int getAnoNascimento(){
        return this.anoNascimento;
    }

    @Override
    public String umMetodo(){
        return "Isso é um método específico da classe PF";
    }

    @Override
    public String toString(){
        return "Nome: "+nome+" Cpf:"+cpf+" E-mail:"+email+" Ano nascimento:"+anoNascimento;
    }
}
