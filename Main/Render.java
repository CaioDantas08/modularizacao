package Main;
import capturas.RunningOptions;

public class Render {

    public static void print(RunningOptions run_opt, String descriptografado, 
                                String criptografado){

        System.out.println("=============================");
        System.out.print("Método processado: " + run_opt.getMetodo() + 
                        "\n" + "Chave processada: " + run_opt.getChave() 
                        + "\n" + "Data processada: " + run_opt.getData() + "\n");

        System.out.print("============/////============\n"
            + "Código descriptografado: \n"
            + descriptografado + "\n"
            + "============/////============\n");

        System.out.print("Código criptografado: \n"
            + criptografado + "\n"
            + "============/////============\n");
                                    
    }
    
}
