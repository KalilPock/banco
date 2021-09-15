public class AppTeste {
    

    public static void main(String[] args){

        ClientePF cliente = new ClientePF("Chico","chico@teste.com","001", 2001);
        
        System.out.println(cliente.toString());
        System.out.println(cliente.umMetodo());

        ClientePJ empresa = new ClientePJ("Empresa Teste","empresa@teste.com","002/09-1",10);
        
        System.out.println(empresa.toString());
        System.out.println(empresa.umMetodo());

    }

}
