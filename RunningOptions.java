import java.io.*;
public class RunningOptions {

    private String texto = "";

    private String formatos_validos[] = {"METHOD", "KEY", "DATA"};

    private String metodo = "";
    private String chave = "";
    private String  data = "";

    public RunningOptions(String texto) throws IOException, CriptografiaException{
        this.texto = texto;
        options();
    }

    //Aqui a gente captura o método, chave e data a partir da string
    //gerada no LeitorArquivo.java, que armazenamos na variável texto
    private void options() throws IOException, CriptografiaException{

        BufferedReader reader = new BufferedReader(new StringReader(texto));

        String linha;
        while ((linha = reader.readLine()) != null) {
            boolean passou_dos_dois_pontos = false;
            String tipo_de_dado = "";
            for(int i = 0; i < linha.length(); i++ ){  

                if(linha.charAt(i) == ':'){
                    boolean formato_valido = false;
                    for(String formato : formatos_validos){
                        if(tipo_de_dado.equals(formato)){
                            formato_valido = true;
                        }
                    }
                    if(!formato_valido){
                        throw new CriptografiaException("Formato inválido: " + tipo_de_dado);
                    }
                    passou_dos_dois_pontos = true;
                    continue;
                }else if(!passou_dos_dois_pontos){
                    tipo_de_dado += linha.charAt(i);
                }
                if(passou_dos_dois_pontos){

                    char c = linha.charAt(i);
                    if (c == ' ' && (metodo.isEmpty() && tipo_de_dado.equals("METHOD")
                        || chave.isEmpty() && tipo_de_dado.equals("KEY")
                        || data.isEmpty() && tipo_de_dado.equals("DATA"))) {
                        continue;
                    }
                    if(tipo_de_dado.equals("METHOD")){
                        metodo += linha.charAt(i);
                    }
                    else if(tipo_de_dado.equals("KEY")){
                        chave += linha.charAt(i);;
                    }
                    else if(tipo_de_dado.equals("DATA")){
                        data += linha.charAt(i);;
                    }
                }
            }
        }  
    }

    public String getTexto() {
        return texto;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getChave() {
        return chave;
    }

    public String getData() {
        return data;
    }
    
}
