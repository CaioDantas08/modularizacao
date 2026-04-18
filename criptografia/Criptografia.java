package criptografia;
import java.util.ArrayList;;
public class Criptografia extends CriptografiaBase implements Decodificador{
   
    private int chave_int = Integer.parseInt(chave) % 95;
    private ArrayList<String> separados = new ArrayList<String>();
    private ArrayList<Integer> elementos_inteiros = new ArrayList<Integer>();
    
    public Criptografia(String chave){
        super(chave);
    }

    private void separar(String texto) throws Exception{

        for(int  i = 0; i < texto.length(); i++){
            String separada = "";
            while(i < texto.length() && texto.charAt(i) != '-'){
                separada += texto.charAt(i);
                i++;
            }
            separados.add(separada);
        }
    }
    private void shift_reverso() throws Exception{

        for(String separado : separados){
            int valor = Integer.parseInt(separado) - chave_int;
            elementos_inteiros.add(32 + ((valor-32) % 95 + 95) % 95);
        }
    }
    @Override
    public String aplicar(String texto) throws Exception{   
        String saida = "";
        for(int i = 0; i < texto.length(); i++){

            char c = texto.charAt(i);
            int valor = (int)c;
            valor = 32 + ((valor - 32 + chave_int) % 95 + 95) % 95;
            saida += valor;

            if(i < texto.length() - 1){
                saida += '-';
            }

        }

        return saida;
    }

    public String decodificar(String texto) throws Exception{

        String saida = "";
        separar(texto);
        shift_reverso();
        for(int item : elementos_inteiros){
            char c = (char) item;
            saida += c;
        }
        elementos_inteiros.clear();
        separados.clear();
        return saida;
    };
    


}