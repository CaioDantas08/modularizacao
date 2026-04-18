package Main;
import Exception.CriptografiaException;
import capturas.RunningOptions;
import capturas.ValidateArguments;
import criptografia.Criptografia;
import leitor.LeitorArquivo;

public class Main{


    public static void main(String[] args) throws Exception{

        LeitorArquivo leitor = new LeitorArquivo(); 
        RunningOptions run_opt = new RunningOptions();
                                                                    
        ValidateArguments validate_arguments = new ValidateArguments(leitor.ler("arquivos/mensagem_especial.txt"));
        validate_arguments.validate(run_opt);

        if(!run_opt.getMetodo().equals("SHIFT")){
            throw new CriptografiaException("Método não suportado");
        }

        Criptografia criptografia = new Criptografia(run_opt.getChave());
   
        String descriptografado = criptografia.decodificar(run_opt.getData());
        String criptografado = criptografia.aplicar(descriptografado);

        Render.print(run_opt, descriptografado, criptografado);

    }
} 