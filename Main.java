public class Main{


    public static void main(String[] args) throws Exception{

        LeitorArquivo leitor = new LeitorArquivo(); 

        RunningOptions run_opt = new RunningOptions();
        ValidateArguments validate_arguments = new ValidateArguments(leitor.ler("codigo.txt"));
        validate_arguments.validate(run_opt);

        if(!run_opt.getMetodo().equals("SHIFT")){
            throw new CriptografiaException("Método não suportado");
        }

        Criptografia criptografia = new Criptografia(run_opt.getChave());
        
        //System.out.print(run_opt.getData() + 
          //              "\n " + run_opt.getMetodo() 
            //            + "\n" + run_opt.getChave());

        //System.out.print(criptografia.decodificar(run_opt.getData()) + "\n");
        //System.out.print(criptografia.aplicar(run_opt.getData()));

    }
}