public class Cliente {
    
    private String cpf;
    private String nome;
    private int anoNascimento;
    private String email;
    
    public Cliente(String nome, String email, String cpf,   int anoNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.email = email;
    }

    public String getCpf(){
        return this.cpf;

    }
    public String getNome() {
        return nome;
    }

    //leitura
    public String getEmail() {
        return email;
    }

    //escrita
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnoNascimento(){
        return this.anoNascimento;
    }

    @Override
    public String toString(){
        return "Nome: "+nome+" Cpf:"+cpf+" E-mail:"+email+" Ano nascimento:"+anoNascimento;
    }
}
