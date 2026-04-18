package capturas;
import java.io.*;
import Exception.CriptografiaException;

public class ValidateArguments{

    private String texto = "";
    private String formatos_validos[] = {"METHOD", "KEY", "DATA"};

    public ValidateArguments(String texto) throws IOException, CriptografiaException{
        this.texto = texto;
    }

    private void check_format(String tipo_de_dado)throws IOException, CriptografiaException{
        boolean formato_valido = false;
        for(String formato : formatos_validos){
            if(tipo_de_dado.equals(formato)){
                formato_valido = true;
            }
        }
        if(!formato_valido){
            throw new CriptografiaException("Formato inválido: " + tipo_de_dado);
        }
    }
    private void parse_line(char c, String tipo_de_dado, RunningOptions RO)throws IOException, CriptografiaException{
        if(tipo_de_dado.equals("METHOD")){
            RO.setMetodo(c);
            }
        else if(tipo_de_dado.equals("KEY")){
            RO.setChave(c);
            }
        else if(tipo_de_dado.equals("DATA")){
            RO.setData(c);
            }
    }
    //Aqui a gente captura o método, chave e data a partir da string
    //gerada no LeitorArquivo.java, que armazenamos na variável texto
    public void validate(RunningOptions RO) throws IOException, CriptografiaException{

        BufferedReader reader = new BufferedReader(new StringReader(texto));

        String linha;
        while ((linha = reader.readLine()) != null) {
            boolean passou_dos_dois_pontos = false;
            String tipo_de_dado = "";
            for(int i = 0; i < linha.length(); i++ ){  
                if(linha.charAt(i) == ':'){
                    check_format(tipo_de_dado);
                    passou_dos_dois_pontos = true;
                    continue;
                }else if(!passou_dos_dois_pontos){
                    tipo_de_dado += linha.charAt(i);
                }
                if(passou_dos_dois_pontos){
                    char c = linha.charAt(i);

                    if(c == ' ' && (RO.getMetodo().isEmpty() && tipo_de_dado.equals("METHOD")
                    || RO.getChave().isEmpty() && tipo_de_dado.equals("KEY")
                    || RO.getData().isEmpty() && tipo_de_dado.equals("DATA"))){
                        continue;
                    }
                    parse_line(c, tipo_de_dado, RO);
                }
            }
        }  
    }
}